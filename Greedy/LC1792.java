/**
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
 *
 * 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
 *
 * 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
 *
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。
 *
 * 输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * 输出：0.78333
 * 解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
 */
class Solution {
	public double maxAverageRatio(int[][] classes, int extraStudents) {
		// 以增长率由大到小排序,增长率最大的优先进行人员添加 -> 优先队列
		PriorityQueue<double[]> pq = new PriorityQueue<>(
				(c1,c2) -> Double.compare((c2[0] + 1) / (c2[1] + 1) - c2[0] / c2[1],(c1[0] + 1) / (c1[1] + 1) - c1[0] / c1[1]));
		double res = 0.0;
		for (int[] c : classes) {
			pq.add(new double[]{c[0],c[1]});
		}
		for (int i = extraStudents;i > 0;i--) {
			double[] minC = pq.poll();
			minC[0]++;
			minC[1]++;
			pq.add(new double[]{minC[0],minC[1]});
		}
		while(!pq.isEmpty()) {
			double[] c = pq.poll();
			res += c[0] / c[1];
		}
		return res / classes.length;
	}
}
