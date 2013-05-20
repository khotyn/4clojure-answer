(fn [num]
  (let [last-digit [\I \V \X]
        ten-digit [\X \L \C]
        hundred-digit [\C \D \M]]
    (letfn [(step [digit roman-digits]
              (if (<= digit 3)
                (apply str (repeat digit (first roman-digits)))
                (if (= digit 4)
                  (apply str [(first roman-digits) (second roman-digits)])
                  (if (<= digit 8)
                    (apply str (cons (second roman-digits) (repeat (- digit 5) (first roman-digits))))
                    (apply str [(first roman-digits) (last roman-digits)])))))
            (append-zero [num-str]
              (apply str (concat (repeat (- 4 (count num-str)) \0) num-str)))]
      (let [num-str (reverse (append-zero (.toString num)))]
        (apply str
          (concat
            (apply str (repeat (Integer/parseInt (str (last num-str))) \M))
            (step (Integer/parseInt (str (nth num-str 2))) hundred-digit)
            (step (Integer/parseInt (str (second num-str))) ten-digit)
            (step (Integer/parseInt (str (first num-str))) last-digit)))))))