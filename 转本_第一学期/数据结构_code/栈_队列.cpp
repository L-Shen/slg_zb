
#include <iostream> 
#define MAX_SIZE 10
#define MAX_SIZE_02 10
using namespace std;

int main01(int argc, char** argv)
{
	
	int stk[MAX_SIZE];
	int top = -1; //  栈顶标志位
	
	int v;
	// 入栈
	for(int i=1;i<5;i++){
		if(top>=MAX_SIZE-1){
			break;
		}
		cin>> v;
		stk[++top] = v;
	} 
 	
	// 栈顶元素 [最后一次进入的元素]
	 int a = stk[top--];  // 出栈后 栈顶 标志位 -1 
	 cout<<"栈顶元素"<<a<<endl;
	 cout<<"当前栈顶标志位为->"<<top<<endl; 	 
	return 0;
}


int main02(int argc, char** argv)
{
	// 两个栈共有一个数组
	int stk[MAX_SIZE_02];
	int top1 = -1;
	int top2 = MAX_SIZE_02;
	int v;
	// 第一个入栈
	for(int i=1;i<5;i++){
		cin>>v;
		if(top1>=top2) break;  // 防止 两个栈干扰 
		stk[++top1] = v;
	} 
	
	// 第二个入栈  入栈本质 就是 下标大的先进入 [栈底 即为数组的后面] 
	for(int i=1;i<5;i++){
		cin>>v;
		if(top2<=top1) break; 
		stk[--top2] = v; 
	} 
	
	
	// 第一个栈顶元素 出栈
	int a = stk[top1--];
	
	// 第二个栈顶元素出栈
	int b = stk[top2++]; 
	
	// 第一个栈顶元素 出栈后遍历
	  	
	return 0;
}

struct student{
	int name;
	struct student *next;
}; 

// 链式 栈 
int main03(int argc, char** argv)
{
	// 定义当前 栈顶
	struct student *top = NULL; 
	
      // 开始入栈   
	for(int i=1;i<=5;i++){
		struct student *s = new struct student;
		s->name = i;
		s->next = NULL; 
		s->next = top; // 链上 
		top = s;		// 当前 栈顶为 s  curHead 表示 top 
	} 
	
	// 最后一次 top 已经指向了 最后一个元素 
	
	// 5-4-3-2-1-top  入栈顺序 
	
	// 入栈 5 4 3 2 1  // 5是最后一个进入 
	struct student *p;
	cout<<"栈序"<<endl; 
	for(p=top;p!=NULL;p=p->next){
		cout<<p->name<<endl;
	} 

	
	// 出栈 栈顶
	p = top;   //  此时之前  p 已经是 NULL top 为最后一个入栈元素 
	top = top->next;
	delete p;
	cout<<"删除栈顶后的栈序"<<endl; 
	for(p=top;p!=NULL;p=p->next){
		cout<<p->name<<endl;
	} 	
	return 0;
} 

// 队列 
int main04(int argc, char** argv)
{

	int que[MAX_SIZE];
	int front = -1;  // 队首 
	int rear = -1; //队尾 
	//入队
	for(int i=1;i<=15;i++){
		if(rear>=MAX_SIZE-1)break;  // 必须 =9 时跳出，否则 数组越界 
		que[++rear] = i; //队尾 后移   1  
	}
	
	// 队序：1 2 3 4 5 6 
	
	// 出队
	int a = que[++front];
	int b = que[++front];
	cout<<"当前front的下标为"<<front<<endl;
	
	for(int i=front+1;i<=rear;i++){
		cout<<que[i]<<endl;
	} 
	
	//  
	
	
	return 0;
}

int main05(int argc, char** argv)
{
	// 循环队列
	int que[MAX_SIZE];
	int front = -1;
	int rear = -1;
	int num = 0;
	for(int i=1;i<=15;i++){
		if(num>=MAX_SIZE)break;
		que[(++rear)%MAX_SIZE] = i;
		num++;		
	} 
	
	// 出队
	int a = que[(++front)%MAX_SIZE];
	num--;
	int b = que[(++front)%MAX_SIZE];
	num--;
	
	// 入队
	for(int i=100;i<=105;i++){
		if(num>=MAX_SIZE)break;
		que[(++rear)%MAX_SIZE] = i;
		num++;		
	} 	
	
	return 0;
} 
 


// 链式队列
struct student_slg{
	int name;
	struct student_slg *next;
	
};

int main(int argc, char** argv)
{
	struct student_slg *front =NULL;
	struct student_slg *rear =NULL;
	// 初始化队列 
	for(int i=1;i<=3;i++){
		struct student_slg *s = new struct student_slg;
		s->name = i;
		s->next = NULL;
		if(i==1){
			front = s;
			rear = s;
		}
		else
		{
			rear->next = s;
			rear = s;
		}		
	}
	// 增加元素 
	struct student_slg *q = new struct student_slg;
	q->name = 100;
	q->next = NULL;
	rear->next = q;
	
	//删除元素
	 

	
	
	
	return 0;
} 

 