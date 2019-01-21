#include <iostream>
using namespace std;


// ��ȱ���
int visited[100];
int arc[100][100];
int vertex[100];
int q[100];

void DFSTsearch(int v){
	cout<<vertex[v]<<" ";
	visited[v]=1;//���øö����Ѿ����� 
	for(int j=0;j<5;j++){
		// ���ھ� 
		if(arc[v][j]==1&&visited[j]==0)  // ���ڹ�ϵ ������û�з��� 
			DFSTsearch(j);
	}
}


int main(){
	int e;//���� 
	int n;//������ 
	int i,j;
	cin>>n>>e; // 5
	
	// ��ʼ������ 
	for(i=0;i<n;i++)
		vertex[i]=i; // v[100] = {0,1,2,3,4} 
	
	 
	// ��ʼ���� 
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			arc[i][j]=0;  // arc[0][0] = 0; arc[0][1] = 0.......arc[4][4]=0
		}
	}
	
	// ָ����ϵ ���� 
	for(int k=0;k<e;k++){
		cin>>i; 
		cin>>j; //�������� ���ܴ��� 
		arc[i][j]=1;
		arc[j][i]=1;
	}
	// �����ϵ 
	cout<<"------ͼ"<<endl; 
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			cout<<arc[i][j]<<" ";
		}
		cout<<endl;
	}
	cout<<endl;
	DFSTsearch(1);	
}