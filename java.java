package slg_day01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

interface SuperDemo {
	void dealSomething();
}

enum Season {
	// 枚举数据类型 【也是类】 编译后 也会有 字节码产生
	Spring, Summer, Autumn, Winter

}

public class Demo {
	final int capacity = 10;  // final 修饰 为常量 也就是说 不能修改其值
	/*
	int 为整形  就是只能定义整数    ---> int a = 10;   不能定义小数 int a = 10.0 这是错误的
	float 这个定义小数的  float a = 1.1;   float a = 1.0;
	double 这个也是定义小数的  和 float 的区别就是 他的小数位数多，小数位数多在程序中叫精度高，感觉高大上，其实就是小数位数多的意思
	一般用 double   double a = 1.0
	String 为字符串   String name = "xxxx";  字符串必须是 " " 
	
	数组：
	什么是数组：
	   数组就好比是一个容器，里面可以放若干个东西，但是这若干个东西必须是 相同类型的
	     ---放石头的容器 就只能放石头，不能放食物
	   那么 
	   --> 在java 中 数组放若干个东西 放整数，放小数，放字符串 
	   
	   怎么定义数组呢？  
	       比如定义一个只能放整数的数组
		   int[] arr = {1，2，336，59，85，6};
		   
		   定义一个只能放小数的数组
		   double[] arr = {1.1,2.2,3.3};
		   
		   定义一个字符串数组
		   String[] arr ={"字符串1","字符串2","字符串3"};
		   
		   
		   所以定义数组的格式为：
		      存放类型+中括号[] = {初始化};
			  
			那么数组是一个容器，那么外界怎么去访问里面的元素呢
			数组就引入了下标，也就是编号 从0 开始，下标为整数
			
			比如：
			int[] arr = {1,2,3,4,5,9};  
			   ---这是一个整形数组
			 现在需要访问 数组里面的 1 很明显 一眼就能看到 1在第一个位置
			 但是 由于语言是老外开发出来的，老外的认知都是 从 0 开始
			 所以没法
			   只能这样去访问  arr[0];
			   那么访问 2  --> arr[1];
			   那么访问 3  --> arr[2];
			   那么访问 4  --> arr[3];
			   那么访问 5  --> arr[4];
			   那么访问 9  --> arr[5];
			   
			   到这里 很容易看到数组存放了 6 个元素 下标范围是 0 到 5 
			   但是呢，数组本身是容器，那么容器会有容量的，那也就是说数组是有容量的，在程序中 数组容量 俗称数组大小，
			   那么在这个例子中，如果访问一个数组下标不存在的，比如访问 arr[6] 就是非法的，
			   在Java 中 如果访问 一个数组不存在的下标，那么就会出错，就会与 ArrayIndexOutOfBoundsException的错误，
			    这个 英文单词就是 Array Index Out of Bounds Exception 的连写
				就是 数组下标越界，这个是不允许的，所以在访问数组元素的时候需要注意下标是不是在范围里面
				
				数组最后一个元素的下标怎么计算呢，
				  这样计算，数组元素个数 - 1；
				  数组元素怎么计算呢，就是一个一个数，只不过这个数 是从 1 开始数
				  比如:
				     int[] arr = {1,2,56,89,58,145,55};
					 最后一个元素的下标为___6_ 
					 首先数元素个数 从1开始数，为 7 个
					 那么 最后一个元素的下标为 7 - 1 =6
					 也就是 arr[6]
					 如果是 arr[7]  就是越界了 这是非法的, 是不允许的。
					 
			   
			   下标是 从0 开始 那么 最后一个元素的下标为 5
			   下标的范围 是 0  到 5   这也就是 6个数
			      --> 比如 0 到 9 有10个数
				这有规律的：
				计算某一个范围内有多少个数的时候：
				 最后一个数 - 最前面的数 + 1 ； 这就是这个范围的数的个数

					0 到 9 ：9-0 +1 =10
					0 到 5： 5-0 +1 =6
					
				布尔类型：、
					布尔是老外起的名字，没什么高大上的东西，就两个值
					一个叫 真 英文 叫 true
					另一个叫  假 英文叫 false;
					我们平常所说的真假是干什么的，是不是用来判断某个事情，到底是不是真的，
					
					程序中的布尔值，也是这样的，用于判断，然后有个词叫 逻辑 就横空出世了，
					
					逻辑的意思就是人经过大脑判断，
					所以在程序中，判断就叫逻辑判断，因为你经过思考了，
					
					那么 布尔类型有什么用呢，又怎么定义呢
					--> 定义：
					boolean flag = false;
					-- 这就定义了一个 布尔形变量 叫 flag 初始值为 false;
					
					有什么用呢？
					  因为存在 条件语句 ，就是 
					  if(条件){
					  
					  }
					  else{
					  
					  }	
					--然后if 的条件 就是 布尔类型的， 如果将 flag当作条件，那么就是假的，
					假的条件是什么概念就是 好比如 ，你在买东西之前对这个东西判断了一下，认为这个东西是假的，那你肯定不会买的，所以你就会离开这家店
					在程序中 如果 if（条件为假） 立马去 else
						就这样
					if(条件为假){
					   这里面的代码就不会执行；
					
					}else{
					   执行这里的代码
					}
					
					多条件判断
					那就是多了个 if（条件为假）
					if(条件){
					  
					
					}else if(条件){
					
					}
					..............
					
					else{
					  
					} 
					 其实和 if else 一个道理
					
					
				运算符：
					= 这个不是等号  是赋值，就是 把谁给谁
					比如 定义一个 整形 a 初始值为 10；
					-----> int a = 10;  // 用程序的话就是说 给 a 赋值为 10；
					
					那什么是 等于 ？
					这个就是 等于 == ,两个 = 就是等于 
					== 等于有什么用呢 ，
					一般我们说 谁等于谁 ，意思就是 这两个值 是一样的，  比如 3 等于 2+1 
					那么程序中 等于 即为 == 也是一样的
					只不过 程序的  == 如果两边相等 ，程序会说 这是真的，只不过电脑不会说话，只能给你一个布尔型的 true;
				    如果这两边的的值 不等 ，那么 程序就会说 这是假的，然后 给你一个 false;
					总结：
					  == ：等于 
					  = ：赋值
					  
					  +，-，*，/，% 这个是 加 减 乘 除  和 取余
					  /：这个是除，得到的结果就是 商
					    比如： int a = 10/4;  然后你心里会想不是 2.5 么 ，怎么输出的是 2，
						这个时候就不能用正常思维来思考，
						/  这个就是取商，这就是程序的规定，
						那么 % 这个就是取余，就是取余数，也是程序规定  
						10 % 4  == 2   因为 10 除以 4 得商为2 余数为 2 【注意这里用的 是 ==】
					
					这里介绍 ！ 这个 在中文中 是 感叹号的意思， 中文的 感叹号 是强调，在程序中 ！代表的是 非
					什么是非 ，非就是不是的意思，
					如果看到的程序是 != 这个就是代表的是 不等于，那为什么不是 !== 这样的么，记住老外也是为了图省事，
					
					!= 这就是 不等于  与赋值 = 这个没有任何关系，
					
					比如在if 判断中
					int a = 10;
					if(a!=10){
					
					}
					else{
						
					}
					// 这个代码就是 如果a不等于 10 执行if 里面的代码，显然这个初始值a 的 初始值 是10 就不会走 if了 直接走的是 else 了
					
					&& 这个代表与，什么是与，就是一起的意思
					一般中文这样说  你与他一起，这个就是强调的是 两个人，一般用于if的条件
					比如
					int a = 10,
					int b = 11;
					if(a ==20 && b ==11){
					
					}else{
					
					}
					// 这里就是 只有在满足 a==10 与 b==10 时 才能进入 if里面的代码  显然这个列子会进入 if 里的代码
					
					如果 平时看到 & 这个也是代表与，但是 & 与 && 的不同就是 &&有短路作用
					
					--
					|| 这个代表或，什么是 或 ，比如中文，你或他 ，强调的是 只要有一个就行了
					比如
					int a = 10;
					int b = 11;
					if(a==10 || b==10){
					
					}
					else{
					
					}
					// 这里 只要在满足 a==10 或者 b==10 就能进入 if里的代码 ，强调一个 所以这里是可以进入if 里的代码
					
					那么在接着看 
					int i = 0;
					i++; 和 ++i 的 区别
					这里需要记住的，
					++ i 最好记：就是 加1；  就是 等同与 i = i + 1;
					
					i++ 就是比较坑的，
					i++ 的规则 叫 先使用 后加 1，
					什么意思呢， 
					比如： 
					 int i = 0;
					 int a = i++; 
					 此时 a  的值为多少 ，这个时候就不是 1了 而是0
					 i的值 又是多少呢， i的值 就是 1；
					 为什么呢？ 根据规则：先使用 ,后加1 的规则，
					 这个先使用 i 的值， 所以就是 a = i;  所以 a 就是 0
					 那么 后加1 是对谁呢，没有别人，就是他自己，也就是 i，i 开始 加1 所以 i的值就是 1
					 
					 如果看到一个光秃秃的 i++，没有 = 赋值的时候 此时 i++ 就是 ++i;
					 比如:
					 int i = 0;
					 i++;
					 i++;
					 最后的 i就是 2 ，因为就是光秃秃的 i++ 等同于 ++i
					 
					 如果数组出现这样的
					 arr[i++] 这个也是先使用 后加1
					 比如：
					 int i = 0;
					 int[10] arr;
					 arr[i++] = 1;  // 此时 就是 arr[0] = 1 ;然后就是 i 自身 +1  i就变成了 1
					 arr[++i] = 2; //这里是就是 arr[2] = 2;
					 
					 
					 那么 i-- 和 --i 是一个道理，这里就不赘述了。
					 
					
					
					
					
						
					
					
				
				循环：
				什么是循环：顾名思义 就是重复 比如循环小数 1.33333333
				
				程序的重复是什么呢？
				 看下面
				 比如 先定义一个 整形 a 初始值为0，
				 然后每次加 1 ，重复100次
				    int a = 1;
					a = a + 1;  // 第一次 结果为 2
					a = a + 1;	// 第二次 结果为 3
					a = a + 1;
					a = a + 1;
					a = a + 1;
					a = a + 1;
					...................
					此时已经发现，这样写下去不切实际，于是老外就在想能不能用几行代码完成呢，于是老外一番努力 就发明了 循环：
					
					// while循环
					while(条件){
					
					
					}
					
					如下代码：
					int a = 10;
					int i = 1;
					while(i<101){
						a = a + 1;
						i = i + 1;					
					}
					// 这几行代码就实现了 100次 a 加 1 的效果，
					要知道，电脑执行代码 是从上到下执行的，
					那么 这几行代码的执行是这样的
					首先 a 的初始值为 10
					 然后 i 的初始值 为 1
					 然后 进入 条件  很明显 i<101 此时 进入 {} 
					 执行 {} 里面的代码，
						 {
							 这里面首先是 a =a +1 ;  此时 a 就为 11
							 然后 i = i + 1; 此时 i 就为 2
						 }
						 到这里{} 里面的代码就执行完毕了，此时程序是暂时不会接着往下执行的，程序回再次回到while(条件)这来
						 再次判断 i<101 ，此时 i的值 是2 很明显 2<101 这是成立的，然后再次进入{}执行这里面的代码。
						 所以就这样，重复判断，实现了100次循环。
						 
 					
					// do while 循环：
					只要理解了 while 循环 这个 do while 循环就很好理解了
					do{
						
						
					}while(条件);
					
					--->
					  int a = 10;
					  int i = 1;
					do{
					  a = a + 1;
					  i = i + 1;
					   
					}while(i<101);  
					// do while  几乎不用 ，了解即可
					
									
				for循环 也就是最常用的就是 for循环，
				
				那么 for循环 又该怎么用呢
				for(初始值;条件;相关操作){
				   //满足条件的执行的代码
				}
				
				比如实现上面的例子
				int a = 0;
				for(a =1;a<101;a++){
					a = a+1;
				}				
				解释：
				一开始 定义一个整形 变量 a ,a的初始值为 0；
				由于程序是从上往下执行的，那么进入 for
				(
				  第一步将a 的 赋为 1；
				  第二步，判断 a 是否小于 101 ，显然 1<101 ，成立 
				  第三步 不是 执行 a++，而是执行{
					  a = a + 1;
					  此时 a = 1+1;
					  即为 a = 2;
				  } 
				  // 强调一下
				  第三步 不是 执行 a++，而是执行{
					  a = a + 1;
					  此时 a = 1+1;
					  即为 a = 2;
				  } 
				  第四步 来到 a<101 这里，再次判断 此时 a=2,显然 2<101 成立
				  再次进入{
					  a = a+1;
					  // 此时  a =2+1; 即为 a= 3
				  }
				  然后周而复始，直到 a=101 此时就已经不能满足 101<101 了 ，程序回立马结束循环
				  
				  可能有点懵，那就这样理解
				  for(①;②;③){
				      ④;
				  }
				  ①:初始化
				  ②：条件判断
				  ③：相关操作
				  ④：满足条件的操作
				  // for 循环执行顺序为
				  ①--->②----->④------>③ ：这是第一个循环
				    ----->②--->④----->③ ：③：相关操作后再次进入 ② 的条件判断，条件成立 进入 ④ 然后在执行  ③ 的相关操作 
					然后再次  ----->②--->④----->③ 重复N 次 直到 ②的条件不成立，立马结束；				  				 
				)
				
				
				// 比如实现 从 1 数到 100
				int i = 0;
				for(i=1;i<101;i++){
					System.out.println(i);  
				}
				// 就这几行代码即可
				
				再比如实现 1+2+3+4+5+.....+100的和
				int i = 0;
				int sum = 0;
				for(i=1;i<101;i++){
					sum = sum + i;
				}
				//多重for循环
				什么是多重for循环 ，就是多个for循环 嵌套 
				就是这样 
				for(){
					for(){
						for(){
							
						}
					}
				}
				// 看到这样的不要慌，一个一个分析就行了，
				就是根据 for循环机制来，最内层的for先循环完
				
				实现 九九乘法口诀表
				int i = 0;
				int j = 0;
				for(i=1;i<=9;i++){
					for(j=1;j<=i;j++){
					  System.out.print(i*j+"="+i+"*"+j);
					}
					System.out.println();
				}
				
				
			  
		   
		   
		   
		   
	   
	
	
	*/

	public static void main(String[] args) {

		// 数组
		int[] arr = { 1, 2, 6, 5, 4 };
		char[] arr1 = new char[5];
		arr1[0] = '1';
		System.out.println((char) ('A' + 1)); // -->B

		/*
		 * Arrays.copyOf(); 拷贝 -----Arrays：工具类 查找元素：Arrays.binarySearch(); 二分查找
		 * 
		 */
		Season s = Season.Autumn; // 枚举
		// 遍历枚举
		Season[] values = s.values(); // shift + alt + L :匹配类型
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}

		// 运算符：
		int i = 0;
		i++;
		++i;
		// i+1;

		System.out.println(2 < 2); // false

		Random random = new Random();
		random.nextInt(10);

	}

	@Test
	/*public void div() {
		// TODO Auto-generated method stub
		for (int j = 1; j <= 50; j++) {
			if (j % 3 == 0)
				System.out.println("被3整除的数有" + j);
			else if (j % 5 == 0)
				System.out.println("被5整除的数有" + j);
			else if (j % 7 == 0)
				System.out.println("被7整除的数有" + j);
			else if (j % 3 == 0 && j % 5 == 0 && j % 7 == 0)
				System.out.println("能被3，5，7整除的数有" + j);
		}
	}*/

	
	// 计算 1000 以内的完数 【完美数】
	/*
	 * 6 = 1+2+3 28 =
	 * 
	 */
	public void div2() {
		// TODO Auto-generated method stub
		int i, j, k;
		for (i = 1; i <= 1000; i++) {
			k = 0;
			for (j = 1; j <= i - 1; j++) {
				if (i % j == 0)
					k += j;// 6/1 k=1, 6/2 k=3, 6/3 k=6
			}
			if (k == i)
				System.out.println("完数为" + i);
		}
	}

	@Test
	// 5+55+555+5555+55555+。。。
/*	public void div3() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("输入的值为");
		int a = sc.nextInt();
		sc.close();
		int count = 1;
		long sum = 0;
		while (count <= 2) {
			a = a * 10 + a;
			sum += a;// 2 +222+22 = 246
			count++;// 2
		}
		System.out.println("12项的和" + sum);
	}*/

	// 增强for循环
	public void enhanceFor() {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 36, 5, 99, 2, 3 };
		for (int element : arr) {
			System.out.println(element);
		}
	}

	// oop
	public void oop() {
		// TODO Auto-generated method stub
		// System.out.println(); 这就是 方法的重载 overloading
		// overload ：同名,参数列表不一致 ，返回值无影响
		/*
		 *  无参构造函数 默认
		 
			10_16 课堂笔记
			this 关键字：代表当前对象 可以当作形式参数 传递当前类对象自身
		 *   用处：区分成员属性 和 局部变量
		 *    普通成员方法 有this 关键字
		 *    静态方法 是不可能出现this关键字的 
		 *      -- 静态方法 只能访问 静态成员变量
		 *      
		 *      修饰符：
		 *         public 
		 *         private 
		 *         protected
		 *         default  默认修饰  
		 *            -- int age =20; 就是 default 只能在同一包中访问
		 *            
		 *            static 关键字
		 *            静态代码块：--> 完成静态成员初始化 
		 *             static{
		 *             
		 *             }
		 
		 
		 *  
		 */
		
		
	}
	
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("hello world");

		Random random = new Random();
		System.out.println(random.nextInt(2018));
	}


	// 最大值
	public void callFindMax() {

		int arr[] = { 1, 2, 365, 98, 5, 6 };
		int max = findMax(arr);
		System.out.println("max=" + max);

		//
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	// findMax()
	public int findMax(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("find max");

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}



	public void test_02() {

		new SuperDemo() {
			@Override
			public void dealSomething() {
				System.out.println("do something");
			}
		}.dealSomething();
	}

	public void printHello() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println("hello world");
		}

	}
	
	// --选择排序
	public void callSelectSort() {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 365, 98, 5, 6 };
		selectSort(arr);
	}

	// selectSort()
	public void selectSort(int arr[]) {
		System.out.println("-----");
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = j + 1; i < arr.length; i++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
	
	// 冒泡排序 _2
	//@Test
	public void bubleSort() {
		int[] arr02 = new int[] { 1, 885, 665, 10, 50, -1 };
		for (int i = 0; i < arr02.length; i++) {
			for (int j = i + 1; j < arr02.length; j++) {
				if (arr02[i] < arr02[j]) {
					int temp = arr02[i];
					arr02[i] = arr02[j];
					arr02[j] = temp;
				}
			}
		}
		System.out.println("===========");
		for (int k = 0; k < arr02.length; k++) {
			System.out.println(arr02[k]);
		}
	}
	
	
	@Test
	// 数组增删改查
	public void call_insertValue() {
		
		// TODO Auto-generated method stub
		int[] arr =new int[10]; 
		arr[0] =10;
		arr[1] = 20;
		System.out.println("------"+arr.length);
		// 在 下标为0之前插入 一个值
		insertValue(arr,0,666);
		deleteValue(arr, 0);
		showArray(arr);

	}
	public void deleteValue(int[] arr,int index) {
		// TODO Auto-generated method stub
		for(int i=index;i<3;i++){
			arr[i]  = arr[i+1];
		}
	}
	public void insertValue(int[] arr,int index,int value) {
		// TODO Auto-generated method stub
		for(int i=1;i>=index;i--){
			arr[i+1] = arr[i];
		}
		arr[index] = value;
	}
	
	
	
	// showArray()
	public void showArray(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("==========");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]+",");
		}
	}

}
