package Heap.MeetingRoomsIII_2402.MeetingRoomsIII_2402_Steven;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair_2404 {
  int number;
  int start;
  int finish;

  public Pair_2404(int number, int start, int finish) {
    this.number = number;
    this.start = start;
    this.finish = finish;
  }
}

public class MeetingRoomsIII_2402_Steven {
  public static int mostBooked(int n, int[][] meetings) {
    int meetingSize = meetings.length;

    Arrays.sort(meetings, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });

    PriorityQueue<Pair_2404> rooms = new PriorityQueue<Pair_2404>(new Comparator<Pair_2404>() {
      @Override
      public int compare(Pair_2404 a, Pair_2404 b) {
        return a.finish == b.finish ? a.number - b.number : a.finish - b.finish;
      }
    });

    int[] roomCnt = new int[n];
    boolean[] isRoomFull = new boolean[n];

    rooms.add(new Pair_2404(0, meetings[0][0], meetings[0][1]));
    roomCnt[0]++;
    isRoomFull[0] = true;

    for (int i = 1; i < meetingSize; i++) {
      int s = meetings[i][0];
      int f = meetings[i][1];
      int delay = 0;

      boolean flag = false;

      while (rooms.size() == n || (!rooms.isEmpty() && rooms.peek().finish <= s)) {
        Pair_2404 room = rooms.poll();
        int prevRoomNum = room.number;

        isRoomFull[prevRoomNum] = false;

        if (room.finish > s && !flag) {
          delay = room.finish - s;
          flag = true;
        }
      }

      for (int j = 0; j < n; j++) {
        if (!isRoomFull[j]) {
          rooms.add(new Pair_2404(j, s + delay, f + delay));

          roomCnt[j]++;
          isRoomFull[j] = true;

          break;
        }
      }

    }

    int res = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (roomCnt[i] > max) {
        max = roomCnt[i];
        res = i;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] meetings = new int[][] { { 1, 27 }, { 29, 49 }, { 47, 49 }, { 41, 43 }, { 15, 36 }, { 11, 15 } };
    int res = mostBooked(n, meetings);
    System.out.println("Res: " + res);

  }
}

// 2 {{0,10},{1,5},{2,7},{3,4}}; res = 0
// 3 {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}} res = 1
// 4 {{19,20},{14,15},{13,14},{11,20}} res = 1
// 3 {{1,27},{29,49},{47,49},{41,43},{15,36},{11,15}} res = 1