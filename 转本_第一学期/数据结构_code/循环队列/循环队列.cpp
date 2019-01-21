#include<iostream>
#include<malloc.h>
#define LENGTH 10;
using namespace std;


/*
  单队列的存在是毫无意义的，
  因为在删除队头元素后，之前队头的空间就是空闲的
  同样 入队 队尾 rear++ 直接越界  ，于是在越界的时候控制，将队尾重新指向第一个元素的位置
  怎么控制：队尾 就是 （rear+1）%数组长度 即可
  出队 也是如此 队头 (front+1)%数组长度 即可

  rear 始终是指向最后一个元素的后面位置，也就是队尾

  队空条件:rear = fornt;

  队满检测：
    因为是循环队列，也就是说 font 和 rear 的大小是无法确定的，
	检测队满的思想就是 
		rear 和 font 相连即可实现 队满检测
		也就是浪费了一个元素
		10 个 元素 9个就满了 
		因为 第十个元素是 用来判断的

*/

typedef struct queue {
	int *arr;
	int fornt;
	int rear;

}QUEUE;

// 创建队列
void create_queue(QUEUE *p) {
	p = (QUEUE*)malloc(sizeof(QUEUE));
}

// 初始化队列
void init_queue(QUEUE *p) {
	p->arr = (int *)malloc(sizeof(int) * 10); // 数组开辟空间
	p->fornt = p->rear = 0;  // 初始化队头和队尾
}

//队满检测
bool full_queue(QUEUE *p) {
	if ((p->rear + 1) % 10 == p->fornt) {   // 这里 p->rear 本身是不会变的，9还是9   
		return true; // 队满了
	}
	return false;

}

// 入队
bool push_queue(QUEUE *p,int value) {
	//队满检测
	if (full_queue(p)) {
		return false;
	}
	else {
		p->arr[p->rear] = value;
		p->rear = (p->rear + 1) % LENGTH; // 始终保持 队尾值向最后一个元素的后面
		return true;
	}
}
// 出队
void pop_queue(QUEUE *p){
	// 检测队空
	if (p->rear == p->fornt) {
		cout << "队空" << endl;
		return;
	}
	//出队
	cout <<"当前队头为"<< p->arr[p->fornt] <<"--已经出去了"<< endl;
	p->fornt = (p->fornt + 1) % LENGTH;
}

//显示整个队
void display_queue(QUEUE *q) {
	cout << "-------队序---------" << endl;
	for (q->fornt;q->fornt < q->rear;q->fornt=(q->fornt+1)%10) {
		cout << q->arr[q->fornt] << endl;
	}
}





int main() {

	QUEUE q;
	create_queue(&q);
	init_queue(&q);

	push_queue(&q, 1);
	push_queue(&q, 2);
	push_queue(&q, 3);
	push_queue(&q, 4);
	push_queue(&q, 5);
	push_queue(&q, 6);
	push_queue(&q, 7);
	push_queue(&q, 8);
	push_queue(&q, 9);
	push_queue(&q, 10);// 10 就已经进不去了 牺牲了

	
	//display_queue(&q);

	pop_queue(&q);
	//pop_queue(&q);
	//pop_queue(&q);

	display_queue(&q);

	system("pause");

}