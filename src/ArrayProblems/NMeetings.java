package ArrayProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1. Idea here is to sort the meeting list by its end time
 * 2. Created a custom comparator to compare the end time and swap the meetings
 * 3. If two meetings have the same end time, sort them as per their position
 * 4. Compare the last meeting end time i.e., limit with the next meeting start time
 *    and if next meeting start is more than previous meeting end time, store it in the result.
 */
public class NMeetings {

    //Store meeting attributes as reference data type
    public static class Meeting {
        int start;
        int end;
        int position;
        Meeting(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }

    static class MeetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            if(o1.end > o2.end) {
                return 1; //Swaps o1 and o2
            } else if(o1.end < o2.end) {
                return -1; //Does nothing
            } else if(o1.position < o2.position) {
                return -1; //if meeting end time is same, swap them as per position
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        int[] start = {1,0,3,8,5,8};
        int[] end = {2,6,4,9,7,9};

        List<Meeting> meet = new ArrayList<>();

        for(int i=0; i<start.length; i++) {
            meet.add(new Meeting(start[i],end[i], i+1));
        }

        MeetingComparator mc = new MeetingComparator();
        meet.sort(mc); //Sort the meetings as per their end time using Meeting Comparator
        List<Integer> result = new ArrayList<>();
        result.add(meet.get(0).start);
        int limit = meet.get(0).end;
        for(int i=1; i<start.length; i++) {
            //compare last meeting endtime with next meeting start time
            if(meet.get(i).start>limit) {
                result.add(meet.get(i).position);
                limit = meet.get(i).end; //update limit to the next meeting end time
            }
        }

        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
