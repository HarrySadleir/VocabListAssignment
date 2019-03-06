import java.util.ArrayList;
class VocabList { 
    //instances==========================================
    private ArrayList<String> words, definitions;
    
    //constructors=======================================
    public VocabList() {
        words = new ArrayList<String>();
        definitions = new ArrayList<String>();
    }

    public VocabList(String[] words, String[] definitions) {
        this.words = new ArrayList<String>();
        this.definitions = new ArrayList<String>();

        for(int i = 0; i < words.length; i++) {
            this.add(words[i], definitions[i]);
        }

    }
    @SuppressWarnings("unchecked")
    public VocabList(VocabList v) {
        
        this.words = (ArrayList<String>)v.words.clone();
        this.definitions = (ArrayList<String>)v.definitions.clone();
    }
    
    //mutators===============================================
    public void add(String word, String definition) {
        int i = 0;
        for(String s : words) {
            if(s.compareTo(word) < 0) {
                i++;
            }
        }

        words.add(i, word);
        definitions.add(i, definition);
    }
    public void remove(String word) {
        for(int i = words.size()-1; i >= 0; i--) {
            if(words.get(i).equals(word)) {
                words.remove(i);
                definitions.remove(i);
            }
        }
    }

    //accessors=============================================
    public String toString() {
        String ans = "";

        for(int i = 0; i < words.size(); i++) {
            ans += words.get(i) + ": " + definitions.get(i) + "\n";
        }
        return ans;
    }
    public int size() {
        return words.size();
    }
    public boolean contains(String word) {
        for(String w : words) {
            if(word.equals(w)) return true;
        }
        
        return false;
    }
    public String getDefinition(String word) {
        for(int i = 0; i < words.size(); i++) {
            if(word.equals(words.get(i))) return definitions.get(i);
        }
        
        return "invalid word";
        
    }
    public String getWord(String definition) {
        for(int i = 0; i < words.size(); i++) {
            if(definition.equals(definitions.get(i))) return words.get(i);
        }
        
        return "invalid definition";
    }
    public String getRandomWord() {
        int index = (int) (Math.random()*words.size());
        return words.get(index);
    }
    public String getRandomDefinition() {
        int index = (int) (Math.random()*words.size());
        return definitions.get(index);
    }
    
    

}
