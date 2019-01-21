#include <iostream>
using namespace std;


// 广度遍历
int visited[100];
int arc[100][100];
int vertex[100];
int q[100];

void DFSTsearch(int v){
	cout<<vertex[v]<<" ";
	visited[v]=1;//设置该定点已经访问 
	for(int j=0;j<5;j++){
		// 找邻居 
		if(arc[v][j]==1&&visited[j]==0)  // 存在关系 ，并且没有访问 
			DFSTsearch(j);
	}
}


int main(){
	int e;//边数 
	int n;//顶点数 
	int i,j;
	cin>>n>>e; // 5
	
	// 初始化定点 
	for(i=0;i<n;i++)
		vertex[i]=i; // v[100] = {0,1,2,3,4} 
	
	 
	// 初始化边 
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			arc[i][j]=0;  // arc[0][0] = 0; arc[0][1] = 0.......arc[4][4]=0
		}
	}
	
	// 指定关系 边数 
	for(int k=0;k<e;k++){
		cin>>i; 
		cin>>j; //两次输入 不能传递 
		arc[i][j]=1;
		arc[j][i]=1;
	}
	// 输出关系 
	cout<<"------图"<<endl; 
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			cout<<arc[i][j]<<" ";
		}
		cout<<endl;
	}
	cout<<endl;
	DFSTsearch(1);	
}