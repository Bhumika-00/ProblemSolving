public class Trie {
    public static class Node{
        Node children[];
        boolean endOfWord;

        Node()
        {
            for(int i=0;i<26;i++)
            {
                children[i]=null;
            }
        }

    }
    public static Node root = new Node();
    public static void insertion(String str)
    {
        Node curr = root;
        for(int i=0;i<str.length();i++)
        {
            int idx = str.charAt(i)-'a';
            if(curr.children[i]==null)
            {
                curr.children[idx]=new Node();
            }
          curr=  curr.children[idx];
        }
        curr.endOfWord=true;
    }
    public static void main(String[] args) {
        String word[]={"the","a","there","their","any","thee"};
        for(int i=0;i<word.length;i++)
        {
            insertion(word[i]);
        }
    }
}
