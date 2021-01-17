package 并查集;

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
			//保存新节点
			if (!parent.containsKey(x)) {
				parent.put(x, x);
				count++;
			}

			//路经压缩
			//当x不是跟节点，将x的父亲节点设置为跟节点
			if (x != parent.get(x)) {
				parent.put(x, find(parent.get(x)));
			}
			//返回x的父亲节点
			return parent.get(x);
		}

		//查询x和y的跟节点
		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);

			//如果在一个连通分量
			if (rootX == rootY) {
				return;
			}

			//否则x根节点指向y的根节点
			parent.put(rootX, rootY);
			count--;
		}
	}

}
