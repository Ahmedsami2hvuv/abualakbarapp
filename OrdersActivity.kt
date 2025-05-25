import android.app.AlertDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class OrdersActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>

    private val orders = mutableListOf<Pair<String, List<String>>>() // العنوان، المنتجات

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        listView = findViewById(R.id.ordersList)
        val addBtn = findViewById<Button>(R.id.addOrderBtn)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        listView.adapter = adapter

        addBtn.setOnClickListener {
            showOrderDialog()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val (title, products) = orders[position]
            Toast.makeText(this, "طلبية: $title\nعدد المنتجات: ${products.size}", Toast.LENGTH_LONG).show()
        }
    }

    private fun showOrderDialog() {
        val input = EditText(this).apply {
            hint = "اكتب الطلبية:\nالعنوان بالسطر الأول، كل منتج بسطر"
            minLines = 5
        }

        AlertDialog.Builder(this)
            .setTitle("إضافة طلبية")
            .setView(input)
            .setPositiveButton("إضافة") { _, _ ->
                val lines = input.text.toString().trim().split("\n")
                if (lines.size >= 2) {
                    val title = lines[0]
                    val products = lines.drop(1)
                    orders.add(title to products)
                    adapter.add(title)
                } else {
                    Toast.makeText(this, "اكتب الطلبية بشكل صحيح", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("إلغاء", null)
            .show()
    }
}