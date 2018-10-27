package com.Amazon;

import java.util.Arrays;
import java.util.Comparator;

public class printAnagrams {

    static class Word{
        Integer index;
        String str;

        public Word(String str, Integer index) {
            this.index = index;
            this.str = str;
        }
    }

    static class DupArray
    {
        Word[] array;
        int size;

        // constructor
        public DupArray(String str[], int size)
        {
            this.size = size;
            array = new Word[size];
            int i;
            for (i = 0; i < size; ++i)
            {
                array[i] = new Word(str[i], i);
            }
        }
    }

    static class compStr implements Comparator<Word>
    {
        public int compare(Word a, Word b)
        {
            return a.str.compareTo(b.str);
        }
    }

    public static void main(String[] args) {

        String wordArr[] = {"cat", "dog", "tac", "god", "act"};
        int size = wordArr.length;
        printAnagramsTogether(wordArr, size);
    }

    private static void printAnagramsTogether(String[] wordArr, int size) {

        DupArray dupArray = new DupArray(wordArr, size);
        int i;
        for (i = 0; i < size; ++i){

            char[] char_arr  = dupArray.array[i].str.toCharArray();
            Arrays.sort(char_arr);
            dupArray.array[i].str = new String(char_arr);
        }
        Arrays.sort(dupArray.array, new compStr());

        for (i = 0; i < size; ++i)
            System.out.print(wordArr[dupArray.array[i].index]+" ");
    }
}
