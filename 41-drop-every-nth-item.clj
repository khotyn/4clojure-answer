(fn
          [a b]
          (letfn
            [(step
               [a b]
               (if
                 (>= (count a) b)
                 (concat
                   (take (- b 1) a)
                   (step (drop b a) b))
                 (take (- b 1) a)))]
            (step a b)))
