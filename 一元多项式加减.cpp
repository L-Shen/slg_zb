#include<iostream>
using namespace std;

typedef struct Node {
	int c;
	int e;
	Node* next;
}*pNode;

/**
   二级指针存放的是一级指针的地址
   一元多项式的相加 即为 指数相同 系数相加， 
   通过建立一个新的链表来合成其计算结果。
*/

// 比较指数大小
int Compare(int e1,int e2) {
	if (e1 > e2) {
		return 1;
	}
	else if (e1 < e2) {
		return -1;
	}
	else {
		return 0;
	}	
}
// 添加
void Attach(int c,int e,pNode* rear){
	pNode p = (pNode)malloc(sizeof(Node));
	p->c = c;
	p->e = e;
	p->next = NULL;
	(*rear)->next = p;
	*rear = p;
}

//
pNode add(pNode p1,pNode p2) {
	pNode front, rear, temp;
	rear = (pNode)malloc(sizeof(Node));
	front = rear;
	int sum = 0;
	while (p1&&p2)
	{
		switch(Compare(p1->e,p2->e)) {
		case 1:
			Attach(p1->c,p1->e,&rear);
			p1 = p1->next;
			break;
		case -1:
			Attach(p2->c, p2->e, &rear);
			p2 = p2->next;
			break;
		case 0:
			sum = p1->c + p2->c;
			if (sum)Attach(sum, p1->e, &rear);
			p1 = p1->next;
			p2 = p2->next;
			break;
		}

	}

	// 拼接剩余项
	// 
	for (; p1; p1 = p1->next)Attach(p1->c,p1->e,&rear);
	for (; p2; p2 = p2->next)Attach(p2->c,p2->e,&rear);

	rear->next = NULL;
	temp = front;
	front = front->next;
	free(temp);
	return front;
}

// 遍历
void trave(pNode front) {
	int i = 1;
	for(;front;front=front->next){
		cout << "第" << i << "项系数为：" << front->c << "   指数为：" << front->e << endl;
		i++;
	}	
}

int main2() {
	pNode node1 = (pNode)malloc(sizeof(Node));
	pNode node2 = (pNode)malloc(sizeof(Node));
	node1->c = 10;
	node1->e = 2;
	node2->c = 11;
	node2->e = 3;
	node1->next = node2;
	node2->next = NULL;

	pNode node3 = (pNode)malloc(sizeof(Node));
	pNode node4 = (pNode)malloc(sizeof(Node));

	node3->c = 10;
	node3->e = 2;
	node4->c = 11;
	node4->e = 3;
	node3->next = node4;
	node4->next = NULL;

	pNode front = add(node1, node3);
	trave(front);

	system("pause");
	
	return 0;
}
