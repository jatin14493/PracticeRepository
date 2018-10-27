package QuestGlobal;




//Problem Statement


/*
Hectic Game
        Alice and Bob are playing a hectic game in which there are a total of  tasks each consisting of a start time  and end time .
        Both players take alternate turns, Alice plays first. In each turn, a player chooses the maximum number of tasks that are non-overlapping as both Alice and Bob can perform only one task at a time.
        In the next turn, the other player will choose the maximum number of tasks that are non-overlapping from the remaining tasks and so on.
        Now, both the players will take XOR (Exclusive - OR) of the total tasks count value obtained in each of their turns. Let the value be  for Alice and  for Bob.
        Now, If , Alice wins. If , Bob wins. If , it's a tie. Find out the winner?

        Note: The ending time  for each selected task in each turn should be as less as possible, e.i. if the given tasks are , , , ,
        Alice can choose maximum 2 tasks in 3 ways as ,  or ,  or , .
        Alice will choose ,  as the ending time for each selected task is as less as possible in this case.

        Input Format

        The first line of the input will be , the total number of test cases.


        The first line of each test case will be , the total number of tasks.

        Then  lines follow each consisting of two space-separated integers  and  the start time and the end time.

        Output Format

        For each test case print the respective result Alice, Bob or Tie.

        Constraints




        Sample Input
        1
        5
        1 2
        1 3
        4 5
        3 4
        1 5
        Sample Output
        Alice
        Explanation
        Initially, there are maximum 2 tasks Alice can choose i.e.  and . From the remaining tasks, Bob can choose maximum 2 tasks i.e.  and . Now, Alice chooses the 1 last task i.e. .

        = 2 ^ 1 = 3

        = 2

        thus, Alice wins.

        Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.

*/

import java.util.*;


class Task {

    long startTime;
    long endTime;

    public Task(long startTime, long endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        //if (obj == this) return true;
        if (!(obj instanceof Task)) return false;
        Task o = (Task) obj;
        return (o.startTime == this.startTime) && (o.endTime == this.endTime);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}


class TaskChainedComparator implements Comparator<Task>{
    private List<Comparator<Task>> list;

    @SafeVarargs
    public TaskChainedComparator(Comparator<Task>... comparators) {
        this.list = Arrays.asList(comparators);
    }

    @Override
    public int compare(Task con1, Task con2) {
        for (Comparator<Task> comparator : list) {
            int result = comparator.compare(con1, con2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

}


class StartTimeComparator implements Comparator<Task> {

    @Override
    public int compare(Task t1, Task t2) {
        return Math.toIntExact((t1.startTime - t2.startTime));
    }
}


class EndTimeComparator implements Comparator<Task> {

    @Override
    public int compare(Task t1, Task t2){
        return Math.toIntExact((t1.endTime - t2.endTime));
    }
}

public class HecticGame {

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while (t-- > 0) {

            List<Task> list = new ArrayList<Task>();
            int n = s.nextInt();
            int j =0;
            while (j < n) {
                Long std = s.nextLong();
                Long etd = s.nextLong();
                list.add(new Task(std, etd));
                j++;
            }


            //Pre processing
            Collections.sort(list, new TaskChainedComparator(new StartTimeComparator(), new EndTimeComparator()));

            //turn = false for Alice
            //turn = true for Bob
            boolean turn = false;

            int alice = 0;
            int bob = 0;
            ArrayList<Task> index;

            while (list.size() > 0) {

                int count = 0;
                Long end = 0L;
                index = new ArrayList<Task>();

                for (int i = 0; i < list.size(); i++) {
                    if (!turn) {
                        //Alice's turn
                        if (count == 0){
                            count++;

                            end = list.get(i).endTime;
                            index.add(list.get(i));
                        } else {
                            Task t1 = list.get(i);
                            if (t1.startTime > end) {
                                count++;

                                end = t1.endTime;
                                index.add(list.get(i));
                            }
                        }
                    } else {
                        //Bob's Turn
                        if (count == 0) {
                            count++;
                            end = list.get(i).endTime;
                            index.add(list.get(i));
                        } else {
                            Task t1 = list.get(i);
                            if (t1.startTime > end) {
                                count++;
                                end = t1.endTime;
                                index.add(list.get(i));
                            }
                        }
                    }
                } //end for loop

                if (!turn) {
                    alice = alice ^ count;
                    turn = true;
                } else {
                    bob = bob ^ count;
                    turn = false;
                }

                for(int i=index.size()-1; i>=0; i--){
                    Task t1 = list.get(i);
                    list.remove(t1);
                }

//                 boolean b = list.removeAll(index);
// //                System.out.println("b : "+ b);
//                 if(b)
//                     index = null;

            } //end inner while loop

            if(alice == bob) {
                System.out.println("Tie");
            } else if(alice > bob) {
                System.out.println("Alice");
            }
            else {
                System.out.println("Bob");
            }

        }// test case end here


    }//main end
}
