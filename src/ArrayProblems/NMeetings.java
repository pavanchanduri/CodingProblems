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

    /**
     * Custom comparator to sort the meetings as per their end time
     * If two meetings have the same end time, sort them as per their position
     * This is to ensure that the meeting which came first in the input list
     * is selected first in case of a tie in end times
     */
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
        int[] end   = {2,6,4,9,7,9};

        nMeetings(start, end);
    }

    /**
     * Find the maximum number of meetings that can be scheduled
     * The algorithm works as follows:
     * 1. Create a list of meetings with their start and end times
     * 2. Sort the meetings based on their end times
     * 3. Iterate through the sorted meetings and select the ones that don't overlap
     * 4. Print the selected meetings
     *
     * @param start - array of start times for the meetings
     * @param end - array of end times for the meetings
     */
    private static void nMeetings(int[] start, int[] end) {
        List<Meeting> meet = new ArrayList<>();

        for(int i=0; i<start.length; i++) {
            meet.add(new Meeting(start[i],end[i], i+1));
        }

        MeetingComparator mc = new MeetingComparator();
        meet.sort(mc); //Sort the meetings as per their end time using Meeting Comparator
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(meet.get(0).start)+" - "+String.valueOf(meet.get(0).end));
        int limit = meet.get(0).end;
        for(int i=1; i<start.length; i++) {
            //compare last meeting endtime with next meeting start time
            if(meet.get(i).start>limit) {
                result.add(String.valueOf(meet.get(i).start)+" - "+String.valueOf(meet.get(i).end));
                limit = meet.get(i).end; //update limit to the next meeting end time
            }
        }

        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
