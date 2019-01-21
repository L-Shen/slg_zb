// 日期 ：10_13 
#include<iostream>
using namespace std;


// 单链表_结构体 
struct student_slg{
	int name;
	int no;
	int age;
	struct student_slg *next;
};

// 双向列表_结构体
struct student_zqg{
	int name;
	int no;
	int age;
	struct student_zqg *prev;
	struct student_zqg *next;
};

//创建双向链表
struct student_zqg* createNode(int name,int no,int age){
	struct student_zqg* p = new struct student_zqg;
	p->name = name;
	p->no = no;
	p->age = age;
	p->prev = NULL;
	p->next = NULL;
	return p;
		
} 


// find n节点之前 【之前的节点】 
struct student_slg* findNode(struct student_slg* head,int n){
	struct student_slg *p = head; 
	for(int i=1;i<n-1;i++){
		p = p->next;
		if(p == NULL){
			return NULL;
		} 		
	}
	return p;	
} 

// 查找元素_单链表 
struct student_slg* findValueByNo(struct student_slg* head, int no){
	for(struct student_slg *p = head;p!=NULL;p=p->next){
		if(p->no == no){
			return p;
		}		
	}
	return NULL;	
} 

// 查找元素_双链表
struct student_zqg* findValueByNo_zqg(struct student_zqg* head, int no){
	for(struct student_zqg *p = head;p!=NULL;p=p->next){
		if(p->no == no){
			return p;
		}		
	}
	return NULL;	
} 

 

int main04(int argc, char** argv)
{
	struct student_slg *head;
	struct student_slg* p = new struct student_slg;  // 开辟内存空间 
	struct student_slg* q = new struct student_slg;
    struct student_slg* z = new struct student_slg;
	
	head = p; // 链表头 
	
	p->name = 1;
	p->no = 1;
	p->age =20;
	p->next = q;
	
	
	q->name = 2;
	q->no = 2;
	q->age = 22;
	q->next = z;

		
	z->name = 3;
	z->no = 3;
	z->age = 25;
	//z->next = null;  // 链表尾 
	
	
	
	 	
	cout<<p->next->name<<endl;
	
	cout<<"name->"<<findNode(head,2)->age<<endl;
	
	// 插入节点
	// p q z
	// p q r z  
	 struct student_slg* r = new struct student_slg; 
	 r->next = q->next;
	 q->next = r;
	 	 	 
	 cout<<r->next->name<<endl;
	 
	 // 查找元素
	 cout<<findValueByNo(head,3)->age<<endl;
	 
	 
	 // 删除节点__存在问题 
    
	 
	return 0;
}




// 
int main05(int argc, char** argv)
{
	
	// 循环单链表
	struct student_slg *head = NULL;
	struct student_slg *p = NULL;
	for(int i=1;i<=10;i++){
		struct student_slg *q = new struct student_slg; 
		q->name = i;
		q->age = i;
		q->no = i;
		q->next = NULL;
		if(i==1){
			head = q;
			p = q;		
		} 
		else{
			p->next = q;
			p = q;						
		}				
	} 
	p->next = head;
	
	// 遍历单循环链表 
	for(p =head;p->next!=head;p=p->next){
		cout<<"当前元素信息为->"<<p->name<<endl; 
	}
	/*
	 for循环结束的时， p已经指向了 最后一个元素  [] 
	
	*/

	
	cout<<"-----------"<<endl;
	
	//单循环列表插入元素  [尾部插入]
	struct student_slg *z = new struct student_slg;
	// 10 1
	// 10 z 1
	z->name = 11;
	z->next = head;  // z->next = p->next;
	p->next = z;
	
	for(p =head;p->next!=head;p=p->next){
		cout<<"当前元素信息为->"<<p->name<<endl; //显示的最后一个 是 10   说明已经在尾部追加上了元素 
	}
	
	return 0;
} 

int main(int argc, char** argv)
{
		// 双向链表
	struct student_zqg* head = NULL;
	struct student_zqg* p = NULL;
	
	for(int i=1;i<=10;i++){
		struct student_zqg* q = createNode(i,i,i*6);
		if(i==1){
			head = q;
			p = q;
		}else{
			p->next =q;
			q->prev = p;
			p =q;
		}
		//cout<<"当前元素地址为"<< &q<<endl; 		
	}
	
	
	// 前置遍历双向链表
/*	for(p=head;p->next!=NULL;p=p->next){
		cout<<"当前元素为"<<p->name<<endl;
	} 
	*/
	cout<<"======"<<endl;
	// 倒置遍历链表
	for(;p!=NULL;p=p->prev){
		cout<<"当前元素为"<<p->name<<endl;		
	} 
	
	// 
	cout<<"5->"<<findValueByNo_zqg(head,5)->name<<endl;
	
	
	// 双向链表增加元素 _未完成 
	
	
	
	
	
	return 0;
}






























