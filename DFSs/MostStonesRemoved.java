package DFSs;

import java.util.*;

public class MostStonesRemoved {
	public static void main(String[] args) {
		int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};

	}

	/*

	 */
	public int removeStones(int[][] stones) {
		UnionFind unionFind = new UnionFind();

		for (int[] stone : stones) {
			// 下面这三种写法任选其一
			// unionFind.union(~stone[0], stone[1]);
			// unionFind.union(stone[0] - 10001, stone[1]);
			unionFind.union(stone[0] + 10001, stone[1]);
		}
		return stones.length - unionFind.getCount();
	}

	private class UnionFind {

		private Map<Integer, Integer> parent;
		private int count;

		public UnionFind() {
			this.parent = new HashMap<>();
			this.count = 0;
		}

		public int getCount() {
			return count;
		}

		public int find(int x) {
			if (!parent.containsKey(x)) {
				parent.put(x, x);
				count++;
			}

			if (x != parent.get(x)) {
				parent.put(x, find(parent.get(x)));
			}
			return parent.get(x);
		}

		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX == rootY) {
				return;
			}

			parent.put(rootX, rootY);
			count--;
		}
	}

}
