class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[10];
    }

    TrieNode root = new TrieNode();

    // Insert number into Trie
    private void insert(int num) {

        String s = String.valueOf(num);

        TrieNode node = root;

        for (char c : s.toCharArray()) {

            int digit = c - '0';

            if (node.children[digit] == null) {
                node.children[digit] = new TrieNode();
            }

            node = node.children[digit];
        }
    }

    // Find longest prefix match
    private int search(int num) {

        String s = String.valueOf(num);

        TrieNode node = root;

        int len = 0;

        for (char c : s.toCharArray()) {

            int digit = c - '0';

            if (node.children[digit] == null) {
                break;
            }

            node = node.children[digit];
            len++;
        }

        return len;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        // Build Trie from arr1
        for (int num : arr1) {
            insert(num);
        }

        int ans = 0;

        // Search arr2 numbers
        for (int num : arr2) {
            ans = Math.max(ans, search(num));
        }

        return ans;
    }
}