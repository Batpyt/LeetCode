package 排序;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println("排序后:");
		for (int i : arr) {
			System.out.println(i);
		}
	}

	private static void quickSort(int[] arr, int low, int high) {

		if (low < high) {
			// 找寻基准数据的正确索引
			int index = getIndex(arr, low, high);

			// 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
			//quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
			quickSort(arr, low, index - 1);
			quickSort(arr, index + 1, high);
		}

	}

	/*
	5 1 2 3 4 6 7
	temp = 5
	4 1 2 3 4 6 7
	4 1 2 3 6 5 7
	 */
	private static int getIndex(int[] arr, int low, int high) {
		// 基准数据
		int tmp = arr[low];
		while (low < high) {
			// 当队尾的元素大于等于基准数据时,向前挪动high指针
			while (low < high && arr[high] >= tmp) {
				high--;
			}
			// 如果队尾元素小于tmp了,需要将其赋值给low
			arr[low] = arr[high];
			// 当队首元素小于等于tmp时,向后挪动low指针
			while (low < high && arr[low] <= tmp) {
				low++;
			}
			// 当队首元素大于tmp时,需要将其赋值给high
			arr[high] = arr[low];

		}

		arr[low] = tmp;
		return low; // 返回tmp的正确位置
	}
}