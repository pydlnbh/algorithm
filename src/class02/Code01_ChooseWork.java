package class02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Code01_ChooseWork {
    // auxiliary class
    public static class Job {
        public int money;
        public int hard;

        public Job(int m, int h) {
            money = m;
            hard = h;
        }
    }

    // auxiliary comparator
    public static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o1.hard != o2.hard ? o1.hard - o2.hard : o2.money - o1.money;
        }
    }

    // solution
    public static int[] getMoneys(Job[] job, int[] ability) {
        Arrays.sort(job, new JobComparator());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(job[0].hard, job[0].money);
        Job pre = job[0];
        for (int i = 1; i < job.length; i++) {
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                pre = job[i];
                map.put(pre.hard, pre.money);
            }
        }

        int[] ans = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            Integer key = map.floorKey(ability[i]);
            ans[i] = key == null ? 0 : map.get(key);
        }

        return ans;
    }

    // main
    public static void main(String[] args) {
        Job[] jobs = new Job[3];
        jobs[0] = new Job(2, 5);
        jobs[1] = new Job(5, 3);
        jobs[2] = new Job(2, 4);

        Arrays.sort(jobs, new JobComparator());

        for (Job job : jobs) {
            System.out.println("hard: " + job.hard + ", money: " + job.money);
        }

        int[] moneys = getMoneys(jobs, new int[]{1, 3, 2});
        for (int money : moneys) {
            System.out.println("money: " + money);
        }
    }
}
