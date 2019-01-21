#include <iostream>
#include <malloc.h> 
using namespace std;
/*
  链式队  
  队头指针  
  队尾指针 
*/ 

typedef struct QNode
{
	int id;
	struct QNode* next;
}LQNode,*QueuePtr;

typedef struct LQueue
{
	QueuePtr front;  // 队头指针 
	QueuePtr rear;  // 队尾指针 
	
}LinkQueue; 

// 初始链队
void InitQueue(LinkQueue *LQ){
	LQ->front = (LQNode*)malloc(sizeof(LQNode));
	LQ->front->next = NULL;
	LQ->rear = LQ->front;  // 初始化队头队尾 
} 

// 入队  入队规则 就是 队尾后移 
void pushQueue(LinkQueue *LQ,int value){
	// 新的元素
	LQNode* qNew = (LQNode*)malloc(sizeof(LQNode)); 
	qNew->id = value;
	qNew->next = NULL;
	LQ->rear->next = qNew;
	LQ->rear = qNew; 	
} 

// 出队
void popQueue(LinkQueue *LQ){
	if(LQ->front == LQ->rear){
		cout<<"队为空 程序终止"<<endl;
		exit(-1); 
	}
	LQNode *p;
	p = LQ->front->next;
	LQ->front->next = p->next;
	free(p); 	
} 


// 获取队头
int getQueueHead(LinkQueue *LQ){
	if(LQ->front==LQ->rear){
		cout<<"队为空 程序已经终止"<<endl; 
		exit(-1); 
	}		 
	int headId = LQ->front->next->id;
	return headId;	
} 

// 显示 队的所有节点id
void displayLQueue(LinkQueue *LQ){
	LQNode * p = LQ->front->next;
	while(p){
		cout<<"ID->"<<p->id<<endl;
		p = p->next;
	}	
} 

// 释放链队
void freeLQueueAllNode(LinkQueue *LQ){
	while(LQ->front){
		LQ->rear = LQ->front->next;
		free(LQ->front);
		LQ->front = LQ->rear; 
	}
	cout<<"这个队已经释放完毕了"<<endl;
	
} 


int main(int argc, char** argv)
{
	LinkQueue* LQ = (LinkQueue*)malloc(sizeof(LinkQueue));
	
	InitQueue(LQ);  //初始化链队 
	
	pushQueue(LQ,1); // 入队 
	pushQueue(LQ,2);
	pushQueue(LQ,3);
	pushQueue(LQ,4);
	
	displayLQueue(LQ); // 1 2 3 4 
	
	popQueue(LQ); // 出队
	cout<<"--------"<<endl; 
	displayLQueue(LQ); // 2 3 4 
	
	int id = getQueueHead(LQ); // 2 
	cout<<"当前队头为"<<id<<endl;
	
	freeLQueueAllNode(LQ); // 释放队 
	
	popQueue(LQ);
	
	return 0;
}
 


















