#include<bits/stdc++.h>

using namespace std;
#define ll long long

int n;
int arr[505050];
ll cnt = 0;

vector <int>msort(int s, int e){
  if(s>=e) return {arr[s]};
  
  vector <int>ret;
  vector <int>t1 = msort(s,(s+e)/2);
  vector <int>t2 = msort((s+e)/2+1,e);
  int p1,p2;
  p1=0;
  p2=0;
  
  for(int i=0;i<=e-s;i++){
    if(p2==t2.size()||(p1<t1.size() && t1[p1]<=t2[p2])){
      ret.push_back(t1[p1]);
      p1++;
    }
    else{
      ret.push_back(t2[p2]);
      cnt+=(t1.size()-p1);
      p2++;
    }
  }

  return ret;
}

int main() {
  scanf("%d",&n);
  for(int i=0;i<n;i++){
    scanf("%d",arr+i);
  }
  vector <int>t=msort(0,n-1);
  
  printf("%lld",cnt);
}
