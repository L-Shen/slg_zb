#include<iostream>
#include<string.h>
#include<iomanip>
#define SIZE 8
using namespace std;

typedef struct Horse{
	int x, y, n;
	Horse *next;
}*Top;

void solve(Top &top,int X,int Y)
{
	if (top->n == SIZE * SIZE)
	{
		int cb[SIZE][SIZE] = {};
		for (; top->next != NULL; top = top->next) {
			cb[top->x][top->y] = top->n;
		}
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				cout << setw(3) << cb[i][j];
			}
			cout << endl;
		}
		cout << endl;
		cout << endl;
		system("pause");
		exit(0);
	}
	if (X < 0||Y < 0||X > SIZE -1||Y > SIZE-1)
	{
		
			return;
	}
	for (Top p = top; p ->next!= NULL; p = p->next)
	{
		if (X == p->x&&Y == p->y) 
		{
			return;
		}
	}
	Top q = new Horse;
	q->x = X;
	q->y = Y;
	q->n = top->n + 1;
	q->next = top;
	top = q;
	solve(top, X - 1, Y - 2);
	solve(top, X - 2, Y - 1);
	solve(top, X - 2, Y + 1);
	solve(top, X - 1, Y + 2);
	solve(top, X + 1, Y + 2);
	solve(top, X + 2, Y + 1);
	solve(top, X + 2, Y - 1);
	solve(top, X + 1, Y - 2);
	top = top->next;
	delete q;
}

int main()
{
	int x, y;
	Top top = new Horse;
	top->x = NULL;
	top->y = NULL;
	top->n = 0;
	top->next = NULL;
	cin >> x;
	cin >> y;
	solve(top, x, y);
	system("pause");
	return 0;
}