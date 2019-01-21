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
	char为字符，就是单个的意思，用'' 包裹起来 比如：char a ='1'; 这个就是字符，
	 --字符串和字符有什么关系呢？
	    字符串 就是 由字符组成的，这就是字符串的本质，
		比如: String str = "123456"; //这是个字符串，那么 1 ,就是这个字符串中的单个字符
		字符是 '' 包裹的，字符串是 "" 包裹的 ，多个字符组成字符串。
	   
	
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
				
		     在循环结束后，程序不会停下的，会执行循环外面的代码，
			 比如:
			 int i = 0;
			 for(i=1;i<=10;i++){
				System.out.println("循环内的代码");
			 }
			 System.out.println("循环外面的代码");
			 运行代码 后 会出现什么效果  
				会输出 10句 循环内的代码  和 1句 循环外面的代码 
			为什么？
				因为 循环执行 10 次 会执行 10次 循环内的 代码
				循环结束后，程序不会结束，会接这往下执行，执行了 一次   System.out.println("循环外面的代码");
				
				
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
				for(1;2;3){
					for(5;6;7){
						8
					}
				}
				根据之前的for循环机制，为什么上面省略了 4 ，因为 4 就是下面的 for循环，
				 -- 更具最里层 for循环 先循环，那么 这个 执行顺序就是 这样的：
				   1 --- 2 ---- 5 ----6 ---8 ---7
						----6 ----8  ----7
						----6 ----8 -----7
						重复 N 次，如果在 N+1 出现 不满足 6，那么 立马跳出 最内层 for循环，
						最内层 跳出后 去哪呢 
						去的是  是  最外层 的 3 
						然后执行 3  之后  就会去 2 进行判断，成立 进入最内层 然后开始 最内层的循环 ，
						  -- 最内层 循环完 又到最外层循环
						 
				
				实现 九九乘法口诀表
				int i = 0;
				int j = 0;
				for(i=1;i<=9;i++){
					for(j=1;j<=i;j++){
					  System.out.print(i*j+"="+i+"*"+j);
					}
					System.out.println();
				}
				
				分析：
				 i = 1 
				   i<=9 成立 
				   进入 最内层的
				   j = 1
				     j<=1成立
					 输出
					去 j++，此时 j = 2
					不成立 ，结束内部循环，到 最外层循环
					i++ ， 即为 i =2
					i<=9 成立 
					进入 内部循环
					j = 1;
					j<=2 成立 
					 输出
					去 j++; 即为 j =2
					j<= 2 成立 
					 输出
					 。。。。。。。。。
					 重复 81 次 就输出 九九乘法口诀表
					 
					注意 之前所说的 i++ ，如果光秃秃的存在，就是 ++i 
					在for循环,光秃秃的存在 ，就是 ++i ，一样的
					为什么是光秃秃的存在吗，因为 ;  即为分号就是一条语句结束的标志
					for(int i =0;i<=9;i++) i++ 之前存在 ; 就是光秃秃的 i++的


					break 和 continue 关键字： 
						什么是关键字，字面意思 就是 关键的字，在程序中，就是 规定好的一些英文单词，
						  比如 break  和 continue 那么这两个关键字有什么用呢 
						  break： 翻译过来就是 打断，打破 比如 break the rules:打破规则
						    break 在程序中 也是打断的意思，是用于 循环的，也就是 跳出循环，执行循环外面的代码
							比如 看下面代码
							int i = 0;
							for(i=1;i<=10;i++){
								if(i==6){
									break;
								}							
							}
							System.out.println(i);  // 循环外代码
							那么 输出  i 的值 是多少  ---> 输出的 是 6 
							分析：
							  i = 1 
							    i<=10 成立
								 进入 
								 if(i==6) 不成立 进不去
							  去 i++  i 变为 2
							     2<=10 成立
								 进入
								 if(i==6) 不成立 进不去
							  去 i++  i 变为 3
							     3<=10 成立
								 进入
								 if(i==6) 不成立 进不去
							.。。。。。。。。。。。
							 去 i++  i变成 6
							      6<=10 成立
								  if(i==6) 成立 进去
								   遇到 break； 
								程序到这遇到  break 关键字 ，立马知道了 要跳出循环了，那么程序就会跳出循环 
								执行 循环外面的代码； 
								
							continue  关键字：这个翻译过来 是 继续，在程序的意思就是 结束当前循环continue 后面的语句 继续下一次循环
								看代码：
							int i = 0;
							for(i=1;i<=10;i++){
								if(i==6){
									continue;
									System.out.println("我是6");
								}							
							}
							System.out.println("我是循环外的代码");  // 循环外代码
							
							是什么效果？ 就是 只有一条语句 我是循环外的代码；
							为什么? 因为 当i== 6 时，进入 遇到 continue  ，程序就知道了，不要执行 continue 后面的语句了，执行下次语句
							循环执行完毕后，就执行最外面的代码 。所以就只有一句 代码 了 也就是  我是循环外的代码
							
							那么会有 continue 和 break 组合使用，肯定没有的 ，为什么， 自己想一想
							
			局部变量 和 全局变量 
			 首先介绍 {} 这个括号
				 {} 这个在中文 叫 花括号，就是一个括号，
				 但是在程序中 {} 这个叫 作用块，每次写程序 都要有个 {} 这个作用块 包裹
				 比如 java 程序的主函数 
				  public static void main(String[] args){
					   // 就出现了第一个{} 
					  
				  }
				  {} 在这里面 才能定义变量，
				  那么 什么是 全局变量 和 局部变量呢 
				    在中文中 全局 和局部的意思 分别对应的范围是不一样的
						全局 对应的范围 比 局部 要大 	那么 在程序 中  也是这个道理，
				     如果一个{} 里面 没有 第二个{} 或者for循环  就不存在 全局 和变量 之说 
					比如：
					{
						int a = 10;
						String str = "hello world";
						System.out.println(a)
						
					}
					那么局部变量 就是 一个 {} 嵌套了 第二个 或者 多个 {} 和 for循环 中定义的 变量
					 那么在 第一个 {} 出现的变量 是 全局变量，嵌套的{} 的 for循环() 定义的变量都是 局部变量 
					 话不多说 看例子
						 public static void main(String[] args){
							 int a = 10;
							 String str ="zzz";
							 for(int i =1;i<=10;i++){
								 int j = 0;
							 }					  
						}
					那么 a ，str 就是全局变量
					i ，j 就是 局部变量
					
					那么谁可以访问谁呢，很明显 全局 可以访问 局部，局部 永远不可能访问 全局的
					  看代码：
					   public static void main(String[] args){
							 int a = 10;
							 String str ="zzz";
							 i = 1;  // 报错 全局不能访问 局部
							 for(int i =1;i<=10;i++){
								 int j = 0;
								 a = 111;  // 正确 局部可以访问 全局
							 }					  
						}
						
			 变量命名规则：
			  int a = 10;   // 定义一个 整形变量 叫 a 初始值 为 10
			   //但是 感觉a 很唐突，为什么叫a,为什么不叫b呢，
			   // 在实际开发中 这个是大忌，变量名不是随意定义，因为时间一长你就不知道这个变量是什么意思了 大忌!!
			   // 一定要根据实际需求，比如定义一个 标志位 那就叫 int flag = 1;
			   // 定义 一个计数器 int count = 10;
			   // 定义 一个求和的函数 int sum(int a,int b){}
			   等  最大忌的定义就是 a,b,c 
			        最无奈的定义就是 拼音 ，这个是万不得已
					最好的就是英文定义变量，最好的
			   
			

				函数：程序也叫 方法
				  什么是函数，在数学中 什么 y=x ,y=x^2 等都是 函数，就是 可以根据一个值 得出另外一个值、
				 在程序中 函数 也是 一个道理 ，根据一个值，可以得到另外一个值 
				 更通俗的说  函数就是实现某个功能，好比如现实生活中的工具箱，工具箱一直存在，只是用的时候拿来就用
				 在程序，函数也是这个道理，函数是工具箱，那么就要现有，然后用的时候拿来用
				    程序中的术语 就是 定义一个函数，然后用的时候 调用一下
				 比如某个函数实现求两个数的最大值，两个数的和等。
				 看例子
				 在 Java 中定义一个 求两个数的最大值的函数
				 int max(int a,int b){
					 if(a>b){
						 return a;
					 }else{
						 return b;
					 }				    
				 }
				 //此时 已经定义一个 求两个数的最大值的函数 此时就是一个工具箱 
				 // 在主函数 需要使用这个求两个数最大值的函数，那么就直接调用
				public static void main(String[] args){
					int a = 5;
					int b = 6;
					max(a,b);
					
				}
				
				 那么 到底 函数的定义格式到底是什么？
				 就是这样的 ：
				   返回值类型 函数名(局部变量){ //局部变量可以没有，一般都需要
					   
				   }
				   那么 是什么 是返回值类型，首先要理解 什么是返回值，
				    在数学的函数中 比如 y=x^2,当 x = 2时， y 就是 4，那么这个y=4 就是 函数值，
					那么在程序中 某个函数实现某个功能，计算出的值，需要返回的值，
					比如实现两个数的最大值，但是 函数本身是工具箱，是被用的，需要返回给调用者;
					 这个时候就 出现了 return 关键字，翻译过来就是 返回
					
					int sum(){
						int a = 10;
						int b = 20;
						if(b>a){
							return b;
						}
						else{
							return a;
						}
						// 这个函数就实现了 求两个数的最大值 						
					}
				 
				  什么是返回值类型？
				  
								 
				那么到这里 基础基本差不多了 那就看一些数组的知识
				因为数组是容器，如果是一个整形数组那里面存放的就是 整数在里面，
					问题来了，一堆数中，那么必定存在最大值，最小值，排序，查找某个数，计算全体和，全体平均值，
					看下面代码：
					int[] arr = {1,2,3,6,5,9,88,100,6};  // 这是一个整形数组
					// 求这堆数的和，数学告诉我们 应该这样求 1+2+3+6+5+9+88+100+6
					// 程序也可以这样求，
					arr[0] + arr[1]+ arr[2]+ arr[3]+ arr[4]+ arr[5]+ arr[6]+ arr[7]+ arr[8]
					// 但是如果这个数组有 1万个数，那怎么办，一个个加 不切实际
					// 所以 for循环就很必要了
					
					复习一下 一维数组的遍历
					 void oneDimensionalArray(int[] arr){
						 for(int i=0;i<arr.length;i++){
							 System.out.println("当前下标元素为"+arr[i])							 
						 }
					 }
					
					//求数组的元素和
					 void arrayValueSum(){
						int[] arr = {1,2,3,6,59,5};
						int sum = 0;
						for(int i=0;i<arr.length;i++){
							sum = sum + arr[i];
						}
						System.out.println("数组的和为"+sum);
					 }
					 
					 //求数组元素的平均值
					 void arrayValueSum(){
						int[] arr = {1,2,3,6,59,5};
						int sum = 0;
						int average = 0;
						for(int i=0;i<arr.length;i++){
							sum = sum + arr[i];
						}
						average = sum / arr.length;
						System.out.println("数组的平均值为"+average);
					 }
					 
					 //求数组的最大值
					 void arrayValueMax(){
						 int[] arr = {1,23,65,9,54,8};
						 int max = 0;
						 for(int i=0;i<arr.length;i++){
							 if(arr[i]>max){
								 max = arr[i];
							 }
						 }
						 System.out.println("数组的最大值为"+max);
					 }
					 
					 // 数组最小值
					  void arrayValueMin(){
						 int[] arr = {1,23,65,9,54,8};
						 int min = 0;
						 for(int i=0;i<arr.length;i++){
							 if(min>arr[i]){
								 min = arr[i];
							 }
						 }
						 System.out.println("数组的最小值为"+min);
					 }
					 
					 // 查找数组中的指定的元素 存在返回其下标,没有返回-1
					 int arrayValueFind(int value){
						 int[] arr = {1,23,65,9,54,8};
						 int flag = 0;
						 for(int i=0;i<arr.length;i++){
							 if(arr[i]==value){
								 flag = 1;
								 break;							 
							 }
						 }
						 if(flag==1){
							 return i;
						 }
						 else{
							 return -1;
						 }						 
					 }
					 
					 //选择排序 【从大到小排序】
					 void selectSort(int[] arr){
						 for(int i=0;i<arr.length-1;i++){  // 倒数第二个
							 for(int j=i+1;j<arr.length;j++){
								 int temp = 0;
								 if(arr[i]<arr[j]){
									 temp = arr[i];
									 arr[i] = arr[j];
									 arr[j] = temp;							 
							 }
						 }						 						 
					 }
				}
					 
					 // 冒泡排序  从大到小排序
					 void bubleSort(int[] arr){
						 for(int i=0;i<arr.length-1;i++){
							 for(int j=0;j<arr.length-i-1;j++){
								 int temp = 0;
								 if(arr[j]<arr[j+1]){
									 temp = arr[j];
									 arr[j] = arr[j+1];
									 arr[j+1] = temp;
									 
								 }
							 }
						 }					 
					 }
					 
					 // 二维数组遍历
					 void twoDimensionalArray(int[][] arr){
						 // 二维数组
						 int[][] arr = {{2,5},{1},{3,2,4},{1,7,5,9}};
						 for(int i=0;i<arr.length;i++){
							 for(int j=0;j<arr[i].length;j++){
								 System.out.println("当前元素为"+arr[i][j]);
							 }
						 }
					 }	 
					 
					 
					 // java 正则表达式
					 什么是正则表达式，就是一个名字，其作用就是 对字符串中单个字符进行相关匹配，
					  ----正则表达式 强调的是 单个字符，单个字符 
					  ----正则表达式 只是对字符串起作用
					 比如 手机号是按照一定规则的字符串，比如 18151860562
					 手机号第一位 必须是 1开头 ，第二位必须是 3或5或7或8，后面的9位就0到9任意字符
					 网站注册 对用户手机会尽心校验，这个校验规则 就会用到 正则表表达式
					 对手机号码的校验 
					     String regex = "^1[1,3,5,8][0-9]{9}";  // 即可实现对手机号的校验
					 强调：正则表达式针对是 字符串中的 单个字符，是单个字符
						"^1[1,3,5,8][0-9]{9}; 
						  -- 具体含义是：
						     ^ 这个表示以什么开头  比如 ^1 就是 以1 开头，^2 就是以2开头，
							 []:这个就是单个字符所在范围,比如:[1,3,5,8] 就是 单个字符必须是 1或3或5或8[强调的是单个字符]，不能为其他的字符
							 [0-9]:这个就很好理解了，就是 0 到9 中任意一个字符
							  [a-z]:代表的就是 a-z 26个小写字母，
							  [A-Z]:代表就是 A-Z 26个大写字母
							 {} 花括号代表的是连续字符位数，要与匹配规则连用，[0-9]{9} 就是表示连续 9位是0到9中的任意字符
							 ^这个如果不是出现在[] 里面 代表的是 以什么开头
							 ^如果出现在[] 就是这样[^匹配规则]代表非， [^9] 就是非9，也就是不是9
							 
					 记住几个重要符号：
						.  任意字符
						*	0到多个字符
						？	0个或1个字符
						+   至少一个字符

						程序运行机制：
						  计算机的三大组件  CPU,内存，硬盘，这些应该都知道，区别就是速度的快慢
						  那么 平时在eclipse 写的程序 运行机制是怎么样的呢？
						   首先我们需要写java代码，然后写完是不是要保存一下，这一步保存对于计算机来说做了这样一件事
						   这件事是将所写的代码从内存保存到硬盘里，不做这一步工具也会提醒你保存的
						   
						   运行java代码这一步计算机也是做了一件事，
						   当 点击 run  as java application 
						   这一步计算机将从硬盘读取代码所在的java文件，调到内存中，然后java虚拟机读取内存中的文件中的代码
						   
						   这就是 代码书写到运行 计算机在背后干的事。
						   
						   对于电脑用来开发
							   所以在程序的世界中，硬盘的容量已经很大了，动不动就是500G，1T
							   CPU 也是越来越强悍， 8核以上比比皆是，多核双线程，也是不用考虑的
							   内存是唯一考虑的，现在标配是 4G，这个是远远不够的，一般都是8G以上，为什么，
							   首先win系统运行占用内存，然后各种软件占用内存，eclipse占用内存，当运行java代码，从硬盘调到内存，
							   虽然现在写的代码都是很少的，虽然不影响性能，但是对于代码，代码跑起来的地点就是内存，由于其他占用内存，内存的效率是不乐观，
							   内存大，是最好的，8G以上就可以了，不是一味的大，内存是很贵的，市面上的4G内存220左右，一个机械硬盘500G也就是300左右，这就是差距，
							   对于程序来说 内存就是程序的世界。
							 服务器端的内存 比如淘宝双十一的服务器内存一般都是256G，为什么 双十一那天数以亿计的请求访问淘宝的服务器，当然淘宝的服务器不是一台，
								是一个群，N台，256G 内存就可以从容处理数以亿计的请求，也有其他技术，比如分布式，服务器集群等。
								内存256G 价格 是 220*（256/4） = 220*64 = 1万4人民币
							
						  那么内存里面到底是什么？
							 内存最小单位是 B 即为字节，1B = 8b 
						     内存是一个容器，类似于一个数组，数组是一个下标对应一个值，内存也是这个道理，只不过内存的下标是 地址，
							 什么是地址：别想多了，就是一个下标，只不过这个下标是一个十六进制表示，开始地址为 0x00.....
							 既然程序在内存中跑起来的，那现在来看变量的真实面目：
							 首先定义一个整形变量： 
							 int a = 4;  
							 这句话就是 定义一个整形变量 a  初始值为 4 ，那么在内存就是 在内存开辟一个空间，这个空间大小为 4B 即为4个字节
							 为什么 是 4B ，这个是c语言始祖 规定的，总结一下常用数据类型在内存占的空间
							 int 4B
							 char 1B
							 String  4B
							 float 4B
							 double 8B
							
							注意 0x00开头的地址块是系统占用的，程序员是不可能操作这块区间
							int a = 4;
							// 内存就是这样的
							0x1234 --> 00000000 00000000 00000000 00000100  
							 // 0x1234  就是 变量a 在内存的地址 地址里面的就是 这个4
							
							 
							 
								
	
						面向对象编程：也叫oop编程，什么是对象，对象不是现实生活中的boyfriend | girlfriend
						在程序中 对象是指一个封装好的一个实体，对象具有属性和方法，程序员在编程时，可以直接通过生成某一事物
						对象来实现对某一事物编程，

						面向对象的的类：
						  什么是类：人类，首先人类这个词就是一个抽象的名词，那么人类到底是什么呢，
						  仔细想想，人类无非是对人的一个概括，人是一个具有吃喝拉撒，眼睛，鼻子，脸，胳膊，肚子，腿等的
						  生物，那么人类这个词就高度概括了人的，所以是抽象的，
						  在编程中 类 也是这样一个概念，类是一个概括，是一个模板，是抽象的，
						  类中的变量 比如 年龄 就是 int age; age虽然是变量，但是在类中 就不能称作为变量了，而是属性了
						  类中的方法，比如吃放和睡觉方法，还是称为方法，也就是函数						 
						  类的英文是 class

						面向对象的对象：
						  一个人是具体的，那么这个人就是一个对象，对象强调的是具体的，是类的具体化，你就是人类具体化，人类高度
						  概括，高度抽象，而你就不是高度抽象的，你有你自己的脸，鼻子等，你有自己的吃饭等功能。所以你就是一个对象

						  类和对象的区别： 
						    类是对某类事物的高度概括，类是抽象的
							对象是某类事物具体的一个个体，是具体的
							
						// 看例子
						// 类
						class People{
							String name; // 名字属性
							int age;  // 年龄属性
							........
							void eat(){
								System.out.println("吃饭方法"); 
							}
							
							void sleep(){
								System.out.println("吃饭方法");
							}
							.........
						}
						
						 类的语法
						 class 类名 {
						    // 属性
							//方法
						 }
						 类名必须为英文，切首字母为大写  上面的 People
						
						以上类就是人类的类，是一个高度概括的集合,
						
						那么怎么产生一个人的对象呢：
						  在java中 通过new 关键字 来产生一个具体对象
						  具体就是 
						  People p = new People();
						

							

					  
					
						
						
							 
						 
					 
					 
					
							
				
				
			  
		   
		   
		   
		   
	   
	
	
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
