#include<iostream>
using namespace std;
			//记匹配串为T  被匹配串为S  位置匹配表明该位置的值（字符）匹配
int* GetBackLoc(char *T)	//获取记录T每一位回溯位置的关系表函数 该关系表以一维数组形式存放 是KMP算法的核心 该版本为未优化的原始版本
{
	int len = strlen(T) ;			//获取T的长度
	int *backLoc = new int[len] {-1};	//初始化关系表 长度为T的长度 第一位回溯位置初始化为-1 方便统一控制
	int k = -1;				//T回溯位置变量
	int j = 0;				//T当前位置变量

	while (j < len - 1)		//循环次数即为T位数-1（长度-1）因为在循环中其实j代表的是所求位置的前一位 故所求位置为j+1 当循环到末尾前一位时
	{			//末尾的回溯位置就得到了 每一位的回溯位置 是由它的前一位（j）决定的 除了起始位置 并且这里的k也是回溯位置的前一位
		if (k == -1 || T[j] == T[k])		//(K==-1)是为了判断没有任何相等的头子串和前子串 有这种情况就把所求位置的回溯位置设为起始位置(0)
						//即所求位置（j+1）的回溯位置为(-1+1=0)并各自挪向下一位进行比对
		{				//或者如果j和k位置的字符相等（T[j] == T[k]）
			backLoc[++j] = ++k;	//所求位置（j+1）的回溯位置即为（k+1）并各自挪向下一位进行比对
		}
		else				//而如果挪过去后的(新j)和(新k)不相等
		{				//把(新k)的回溯位置赋值回给(新k)这是为了回到头子串本身的重复位置的后一位  存在就从这一位继续比对  不存在重复位置自然就变成-1 
			k = backLoc[k];						
		}				//继续比对(新j)和k的值直到匹配成功（说明头子串中还有与前子串重复的部分）或者判断到(新j)与第一位都不相等(即不存在重复位置)为止 
	}									
	return backLoc;
}

int KMP(char *S, char *T)
{
	int i = 0;			//初始化T和S的比对字符位置
	int j = 0;
	int *backLoc = GetBackLoc(T);		//获得关系表
	for (int i=0; i < strlen(T); i++)
	{
		cout << backLoc[i] << " ";
	}
		cout << endl;
	while (T[j]!='\0' && S[i] != '\0')
	{    
		if (j == -1 || S[i] == T[j])	//T当前位置和S当前位置匹配 T和S的位置都移到下一位继续匹配  
		{			//或者 T的第一位就与S不匹配 S的位置移到下一位 T的位置挪到开头
			i++;
			j++;
		}
		else
		{
			cout << "T回溯到第"<<backLoc[j]<<"位" << endl;		
			j = backLoc[j];			//T返回到该不匹配位置对应的回溯位置
		}
	}
	delete[] backLoc;	//销毁关系表占用空间
	if (T[j] == '\0')	//该部分逻辑与BF算法相同 
		return i - j;
	else
		return -1;
}

int main()	//测试函数
{
	char S[] = "abadcabcacabaabcacbcacbc";
	char T[] = "abaabcac";
	cout << KMP(S, T);
}