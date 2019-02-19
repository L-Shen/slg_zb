#include<iostream>
using namespace std;

struct List {		//循环链表节点结构体
	int index;
	List *next = NULL;
};

List *initList(int l) {		//循环链表初始化函数
	if (l == 0)
	{
		cout << "输入错误 ";
		return 0;
	}
	else
	{
		List *front = NULL;  //该部分其实是一个链队列
		List *rear = NULL;
		for (int i = 0; i < l; i++)
		{
			List *p = new List;

			p->index = i + 1;
			p->next = NULL;
			if (front == NULL)
			{
				front = rear = p;
			}
			else
			{
				rear->next = p;   //这一步会把头指针即front的next接上p 
				rear = p;			//把尾指针挪到最后一位
			}
		}
		rear->next = front;		//连接头尾
		return front;
	}
}

List * delList(List *item, int len) {		//删除循环链表中指定元素函数
	List *p = item;

	for (int m = 1; m < len; m++)
	{
		p = p->next;		//把当前元素 循环到指定元素的前一个元素
	}

	List *q = p->next;			//获取指定元素本身
	cout << q->index << " ";    //输出该元素的序号
	p->next = item->next;		//把指定元素前一个元素的下一个改为指定元素的下一个元素  即令指定元素脱离循环
	delete q;					//删除指定元素节点
	return p;
}



int main()
{
	int len;			//总人数
	int num;			//出列数
	int k;				//起始位置编号
	int j = 0;			//报数计数
	cin >> len;
	cin >> k;
	cin >> num;

	printf("测试");//

	List *list = initList(len);	//初始化循环链表 长度

	for (int i = 1; i < k; i++)	//将循环链表起始位置挪到输入的起始位置
	{
		list = list->next;
	}
	while (len != 0)			//在所有成员出列后停止循环
	{
		j++;					//每次循环报数+1
		if (j == num)			//判断报数是否等于出列数
		{
			list = delList(list, len);//删除指定元素
			len--;				//循环链表长度-1
			j = 0;				//重置报数计数
		}
		list = list->next;		//每次循环把元素挪到下一个
	}
	return 0;
}