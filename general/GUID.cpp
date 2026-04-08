#include <cstring>
#include <string>
#include <vector>
#include <iostream>
using namespace std;

struct Node {
    int nxt[16];
    Node() {
        memset(nxt, -1, sizeof(nxt));
    }
};

int n;
string val;
vector<vector<int>> adj;
vector<Node> trie(1); // root = 0

int getVal(char c) {
    if (c >= '0' && c <= '9') return c - '0';
    return c - 'a' + 10;
}

void dfs(int u, int p, int node) {
    int c = getVal(val[u]);

    if (trie[node].nxt[c] == -1) {
        trie[node].nxt[c] = trie.size();
        trie.emplace_back();
    }

    int nxtNode = trie[node].nxt[c];

    for (int v : adj[u]) {
        if (v == p) continue;
        dfs(v, u, nxtNode);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    cin >> val;
    val = " " + val;

    adj.resize(n + 1);
    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 1; i <= n; i++) {
        dfs(i, 0, 0);
    }

    // number of nodes - 1 (exclude root)
    cout << trie.size() - 1 << '\n';

    return 0;
}