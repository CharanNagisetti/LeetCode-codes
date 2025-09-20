import java.util.*;

class Router {

    private int memoryLimit;
    private Queue<int[]> queue; // FIFO packets
    private Set<String> packetSet; // for duplicates

    // For each destination we keep:
    //   - timestamps (sorted)
    //   - prefix counts
    private Map<Integer, List<Integer>> destTimestamps;
    private Map<Integer, List<Integer>> destPrefixCounts;

    // Track how many packets removed at each (dest,timestamp)
    private Map<Integer, TreeMap<Integer, Integer>> removedCounts;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.packetSet = new HashSet<>();
        this.destTimestamps = new HashMap<>();
        this.destPrefixCounts = new HashMap<>();
        this.removedCounts = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (packetSet.contains(key)) return false;

        // If full, evict oldest
        if (queue.size() == memoryLimit) {
            int[] old = queue.poll();
            String oldKey = old[0] + "#" + old[1] + "#" + old[2];
            packetSet.remove(oldKey);

            // Mark one removed for that dest,timestamp
            removedCounts.putIfAbsent(old[1], new TreeMap<>());
            TreeMap<Integer, Integer> rmap = removedCounts.get(old[1]);
            rmap.put(old[2], rmap.getOrDefault(old[2], 0) + 1);
        }

        // Add new packet
        queue.offer(new int[]{source, destination, timestamp});
        packetSet.add(key);

        // Update prefix sums
        destTimestamps.putIfAbsent(destination, new ArrayList<>());
        destPrefixCounts.putIfAbsent(destination, new ArrayList<>());

        List<Integer> tlist = destTimestamps.get(destination);
        List<Integer> plist = destPrefixCounts.get(destination);

        int prev = plist.isEmpty() ? 0 : plist.get(plist.size() - 1);
        tlist.add(timestamp);
        plist.add(prev + 1);

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];

        int[] pkt = queue.poll();
        String key = pkt[0] + "#" + pkt[1] + "#" + pkt[2];
        packetSet.remove(key);

        // Mark removed
        removedCounts.putIfAbsent(pkt[1], new TreeMap<>());
        TreeMap<Integer, Integer> rmap = removedCounts.get(pkt[1]);
        rmap.put(pkt[2], rmap.getOrDefault(pkt[2], 0) + 1);

        return pkt;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimestamps.containsKey(destination)) return 0;

        List<Integer> tlist = destTimestamps.get(destination);
        List<Integer> plist = destPrefixCounts.get(destination);

        if (tlist.isEmpty()) return 0;

        // prefix up to endTime
        int idxEnd = upperBound(tlist, endTime); // index of last <= endTime
        if (idxEnd < 0) return 0;
        int countEnd = plist.get(idxEnd);

        // prefix up to startTime - 1
        int idxStart = upperBound(tlist, startTime - 1);
        int countStart = idxStart >= 0 ? plist.get(idxStart) : 0;

        int raw = countEnd - countStart;

        // subtract removed counts
        if (!removedCounts.containsKey(destination)) return raw;
        TreeMap<Integer, Integer> rmap = removedCounts.get(destination);
        // removed counts in range
        int removed = 0;
        for (Map.Entry<Integer, Integer> e :
                rmap.subMap(startTime, true, endTime, true).entrySet()) {
            removed += e.getValue();
        }

        return raw - removed;
    }

    // Returns index of last element <= x, or -1 if all > x
    private int upperBound(List<Integer> list, int x) {
        int lo = 0, hi = list.size() - 1, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (list.get(mid) <= x) {
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }
}
