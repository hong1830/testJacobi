package testJacobi;

import java.util.Scanner;

public class Jacobi {

	/**
	 * 
	 * @Jacobi迭代法求线性方程组
	 */

	static double a[][];

	static double b[];

	static double x[];

	static double x0[];

	static boolean th = true;

	static int count = 0;

	static int n = 0;

	static double e = 0;

	public static void main(String[] args) {

		inPut();

		iteration(e);

	}

	private static void inPut() {

		Scanner as = new Scanner(System.in);

		System.out.print("输入方程组的元数：");

		n = as.nextInt();

		a = new double[n][n];

		b = new double[n];

		x0 = new double[n];

		x = new double[n];

		System.out.println("输入方程组的系数矩阵a：");

		for (int i = 0; i < n; i++)

			for (int j = 0; j < n; j++)

				a[i][j] = as.nextDouble();

		System.out.println("输入方程组矩阵b：");

		for (int i = 0; i < n; i++)

			b[i] = as.nextDouble();

		System.out.println("输入精度10^(-e)：");

		e = as.nextDouble();

	}

	private static void iteration(double n) {

		double sum = 0;

		for (int i = 0; i < x0.length; i++) {

			x0[i] = 0; // 初值都为1

		}

		while (th) {

			count++;

			for (int i = 0; i < x0.length; i++) {

				sum = 0;

				for (int j = 0; j < x0.length; j++) {

					if (i != j) {

						sum = sum + a[i][j] * x0[j];

					}

				}

				x[i] = (b[i] - sum) / a[i][i];

			}

			System.out.println("第" + count + "次迭代的值");

			print1(x);

			if (jisuan() < Math.pow(10, -n)) {

				th = false;

			}

			for (int i = 0; i < a.length; i++) {

				x0[i] = x[i];

			}

		}

	}

	/*
	 * 
	 * 求出前一次迭代和后一次迭代对应x的最大误差值max， 如果max小于精度要求则所求的x值都满足要求
	 */

	public static double jisuan() {

		double max = 0.0;

		for (int i = 0; i < x.length; i++) {

			double x3 = Math.abs(x[i] - x0[i]);

			if (x3 > max)

				max = x3;

		}

		return max;

	}

	private static void print1(double[] y) {

		for (int i = 0; i < y.length; i++) {

			System.out.println("x[" + i + "]=" + y[i]);

		}

	}

}
