http://writingcoding.blogspot.com/2008/06/tokenization-part-7-file-reading.html
(defn tokenize
  ([filename] (tokenize-str (slurp filename)))
  ([filename stop-word?] (tokenize-str (slurp filename)
                                       stop-word?))) 
