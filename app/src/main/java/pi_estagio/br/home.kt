package pi_estagio.br

import HorizontalAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_horizontal_layout)

        val itemList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        val horizontalRecyclerView: RecyclerView = findViewById(R.id.recycler_horizontal)
        val horizontalAdapter = HorizontalAdapter(itemList)

        horizontalRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView.adapter = horizontalAdapter

    }
}