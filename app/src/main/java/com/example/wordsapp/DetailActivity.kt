/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wordsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val LATTER = "latter"
        const val SEARCH_PREFIX = "https://www.goole.com/search?q="
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Извлеките объект привязки, который позволяет вам ссылаться на представления по имени идентификатора
        // Имена преобразуются из регистра snake в регистр camel.
        // Например, на представление с идентификатором word_one ссылаются как на привязку.слово первое
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Извлеките ПИСЬМО из приложения Intent extras
        // intent.extras.getString возвращает строку? (Строка или null)
        // таким образом, toString() гарантирует, что значение будет строкой
        val letterId = intent?.extras?.getString(LATTER).toString()

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordAdapter(letterId, this)

        // Добавляет [DividerItemDecoration] между элементами
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        title = getString(R.string.detail_prefix) + " " + letterId
    }
}