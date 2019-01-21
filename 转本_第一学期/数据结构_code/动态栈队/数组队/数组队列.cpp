#include <iostream>
#include <malloc.h> 
using namespace std;


// 队列的规则 就是 先进先出 ，就是食堂打饭排队，谁在前 谁就先出队
// 数组实现队列

typedef struct Queue{
	int*queue; // 数组 
	int front;// 队头 
	int rear; // 队尾 
	int count; // 计数 
}QUEUE,*LPQUEUE;


// 创建队列
void createQueue(LPQUEUE Q){
	Q->queue = (int*)malloc(sizeof(int)*10); // 为数组开辟空间
	Q->front = Q->rear = Q->count = 0; // 初始化队头，队尾，和计数器 	
} 
// 检测队是否为空
int isEmptyQueue(LPQUEUE Q){
	if(Q->count == 0) return -1;
	return 0; // 非空返回 0 
}

// 入队
void push(LPQUEUE Q,int value){
	if(Q->count == 10){
		cout<<"当前队已经满了 不能入队了"<<endl;
		return; 
	}
	Q->queue[Q->rear++] = value; // 元素入完队， 队尾后移一位
	Q->count++;  // 计数+1 
} 

// 出队
int pop(LPQUEUE Q){
	if(isEmptyQueue(Q)){
		cout<<"队为空了，无法出队了"<<endl;
		return -1;
	} 
	int popValue = Q->queue[Q->front++];
	Q->count--;
	return popValue;	
} 

// 获取队头元素
int getFrontValue(LPQUEUE Q){
	return Q->queue[Q->front];
}

int main(int argc, char** argv)
{

	 LPQUEUE Q = (LPQUEUE)malloc(sizeof(QUEUE)*10); // 为整个队开辟空间 
		
	 createQueue(Q);// 创建队列	 
	 push(Q,1);
	 push(Q,2);
	 push(Q,3);
	 // 入队 1 2 3 
	 
	 cout<<"出队:"<<pop(Q)<<endl; 
	 cout<<"出队:"<<pop(Q)<<endl;
	 cout<<"出队:"<<pop(Q)<<endl;
	 // 出队 1 2 3 
	  
	int frontValue = getFrontValue(Q);
	cout<<"当前队头为"<< frontValue<<endl; 
	
	return 0;
} 
 









