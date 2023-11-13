/*
 * @Author: demussong
 * @Description: todo 写了一个小时呀呀呀呀呀呀！！！！！
 * @Date: 2023/8/20 11:10
 */
public class S208 {

}
class Trie {

    private boolean isEnd;

    private Trie[] next;

    public Trie() {
        next = new Trie[26];
    }

    public void insert(String word) {
        Trie tmp = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (tmp.next[index] == null) {
                tmp.next[index] = new Trie();
            }
            tmp = tmp.next[index];

        }
        tmp.isEnd = true;
    }





    public boolean search(String word) {


        Trie tmp = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (tmp.next[index] == null) {
                return false;
            }else {
                tmp = tmp.next[index];

            }
        }

        return tmp.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie tmp = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (tmp.next[index] == null) {
                return false;
            }else {
                tmp = tmp.next[index];

            }
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }
}
