#include <csdtdio>
#include <iostream>
#include <cstring>

using namespace std;
##define N 90005;

struct SamNode {
    int l, sc;
    SamNode *son[26], *f;
}