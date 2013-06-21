(fn [a b]
          (apply
            max
            (filter
              #(and
                 (= (rem a %) 0)
                 (= (rem b %) 0))
              (range
                1
                (+
                  (min a b)
                  1)))))
