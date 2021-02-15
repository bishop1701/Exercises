public static class Element {
        private char _letter;
        private int _count;
        private Element _next;

        public Element () {
            _letter = ' ';	// space character
            _count = 0;
            _next = null;
        }

        public char getLetter()  {return _letter;}
        public int getCount()  {return _count;}
        public Element getNextElement() {return _next;}


    }

    public static int encodedStringCmp(Element str1, Element str2) {
        Element current1 = new Element();
        current1._letter = str1.getLetter();
        current1._next = str1.getNextElement();
        Element current2 = new Element();
        current2._letter = str2.getLetter();
        current2._next = str2.getNextElement();
        int answer = 0;

        while (current1 != null && current2 != null) {

            if (current1.getLetter() == current2.getLetter()) {
                current1 = current1.getNextElement();
                current2 = current2.getNextElement();
            } else if (current1.getLetter() > current2.getLetter()) {
                answer = 1;
                current1 = current1.getNextElement();
                current2 = current2.getNextElement();
            } else if (current1.getLetter() < current2.getLetter()) {
                answer = -1;
                current1 = current1.getNextElement();
                current2 = current2.getNextElement();
            }
        }
        if (current1 == null || current2 != null) {
            answer = -1;
        } else {
            answer = 1;
        }
        
        return answer;
    }
