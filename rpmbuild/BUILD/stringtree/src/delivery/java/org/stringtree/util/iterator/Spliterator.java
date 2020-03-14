package org.stringtree.util.iterator;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.Map;

public class Spliterator extends AbstractIterator {

    public static final char TT_ORDINARY = 'O';
    public static final char TT_SEP = 'S';
    public static final char TT_PAD = 'P';
    public static final char TT_QUOTE = 'Q';
    public static final char TT_END = 'E';
    public static final char TT_ESCAPE = 'X';
    public static final char TT_NONE = 'N';

    protected Map types;
    protected CharacterIterator cit;
    protected char c;
    protected char ttype;
    protected char inquote = 0;
    protected boolean eatseps = true;
    protected boolean eatquotes = true;

    public Spliterator(String string, String seps) {
        types = new HashMap();
        reset(string);
        setSeparators(seps);
    }

    public Spliterator(String string) {
        this(string, " ");
    }

    public Spliterator() {
        this("");
    }

    public void reset(String string) {
        cit = new StringCharacterIterator(string);
        ttype = TT_NONE;
    }

    public void setType(char c, char type) {
        types.put(new Character(c), new Character(type));
    }

    public void setType(char from, char to, char type) {
        for (char c = from; c <= to; ++c) {
            setType(c, type);
        }
    }

    public void setType(String seps, char type) {
        CharacterIterator it = new StringCharacterIterator(seps);
        for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
            setType(c, type);
        }
    }

    public void setSeparators(String chars, boolean eat, boolean clear) {
        if (clear) clear();
        setType(chars, TT_SEP);
        eatSeparators(eat);
    }

    public void setSeparators(String chars) {
        setSeparators(chars, true, true);
    }

    public void addSeparators(String chars) {
        setSeparators(chars, true, false);
    }

    public void setPadding(String chars) {
        setType(chars, TT_PAD);
    }

    public void setQuotes(String chars, boolean eat) {
        setType(chars, TT_QUOTE);
        eatQuotes(eat);
    }

    public void setQuotes(String chars) {
        setQuotes(chars, true);
    }

    public void clear() {
        types.clear();
    }

    public void eatSeparators(boolean b) {
        this.eatseps = b;
    }

    public void eatQuotes(boolean b) {
        this.eatquotes = b;
    }

    protected void catchup() {
        if (ttype == TT_NONE)
            start();

        while (ttype == TT_PAD) {
            advance();
        }
    }

    protected void start() {
        c = cit.first();
        ttype = type(c);
    }

    protected void advance() {
        c = cit.next();
        ttype = type(c);
        if (ttype == TT_ESCAPE) {
            char ec = cit.next();
            c = convertEscape(ec);
            ttype = TT_ORDINARY;
        }
    }

    protected char convertEscape(char c) {
        switch (c) {
        case 't':
            return '\t';
        case 'n':
            return '\n';
        case 'r':
            return '\r';
        }
        return c;
    }

    protected char type(char c) {
        if (c == CharacterIterator.DONE)
            return TT_END;

        char ret = TT_ORDINARY;
        Character cc = new Character(c);
        if (types.containsKey(cc)) {
            ret = ((Character) types.get(cc)).charValue();
        }

        return ret;
    }

    protected boolean isquote(char inquote) {
        return ttype == TT_QUOTE && c == inquote;
    }

    public Object next() {
        catchup();
        if (ttype == TT_END)
            return null;

        if (ttype == TT_SEP) {
            if (!eatseps) {
                char sep = c;
                advance();
                catchup();
                return Character.toString(sep);
            }

            advance();
            catchup();
        }

        StringBuffer buf = new StringBuffer();

        if (ttype == TT_QUOTE) {
            inquote = c;
            if (eatquotes)
                advance();

            do {
                buf.append(c);
                advance();
            } while (!isquote(inquote) && ttype != TT_END);

            if (!eatquotes)
                buf.append(c);
            advance();
        } else {
            int oldtt = ttype;
            while (ttype == oldtt && ttype == TT_ORDINARY) {
                buf.append(c);
                advance();
            }
        }

        return buf.toString();
    }

    public boolean hasNext() {
        catchup();
        return ttype != TT_END;
    }

    public String tail() {
        if (ttype == TT_END)
            return "";

        StringBuffer ret = new StringBuffer();
        while (c != CharacterIterator.DONE) {
            ret.append(c);
            c = cit.next();
        }

        return ret.toString();
    }

    public String nextString() {
        return (String) next();
    }
}
