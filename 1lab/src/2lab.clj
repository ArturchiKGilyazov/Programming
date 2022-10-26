(def N 5)
(def symbols ['a 'b 'c])
(println N)
(println symbols)
(defn extend-word [word, alphabet, result-word]             ; создаём слово
  (cond
    (= (count alphabet) 0) result-word                      ; если алфавит кончился ворачиваем слово
    (= (first word) (first alphabet)) (extend-word word (rest alphabet) result-word) ; скипаем повторяющуюся букву
    :default (recur
               word
               (rest alphabet)
               (conj result-word (cons (first alphabet) word))) ;конкатим букву к слову и вызываем рекурсивно добавление буквы к слову
    )
  )

(defn extend-words [words, alphabet, result-words]          ; добавить новое слово
  (if
    (= (count words) 0) result-words                        ; если символов не осталось, то выводим слово обратно
                        (recur
                          (rest words)
                          alphabet
                          (concat result-words (apply str (extend-word (first words) alphabet (list)))))

                        )
  )

(defn make-words [alphabet max-length]
  (if
    (= max-length 0) (list (str))
                     (extend-words (make-words alphabet (dec max-length)) alphabet (list))
                     )
  )

(defn startFirstLab [list max-length]
  (let [result (make-words list max-length)]
    (println (str "result: ") result))
  )

(startFirstLab symbols N)