(fn
          [s]
          (reduce str
            (re-seq #"[A-Z]" s)))
