import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CouriersActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>

    private val couriers = mutableListOf<Pair<String, String>>() // الاسم، الرابط

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_couriers)

        listView = findViewById(R.id.couriersList)
        val addBtn = findViewById<Button>(R.id.addCourierBtn)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        listView.adapter = adapter

        addBtn.setOnClickListener {
            showAddDialog()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val url = couriers[position].second
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            Toast.makeText(this, "تعديل المندوب: ${couriers[position].first}", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun showAddDialog() {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
        }

        val nameInput = EditText(this).apply { hint = "اسم المندوب" }
        val urlInput = EditText(this).apply { hint = "رابط المندوب" }

        layout.addView(nameInput)
        layout.addView(urlInput)

        AlertDialog.Builder(this)
            .setTitle("إضافة مندوب")
            .setView(layout)
            .setPositiveButton("إضافة") { _, _ ->
                val name = nameInput.text.toString()
                val url = urlInput.text.toString()
                if (name.isNotEmpty() && url.isNotEmpty()) {
                    couriers.add(name to url)
                    adapter.add(name)
                }
            }
            .setNegativeButton("إلغاء", null)
            .show()
    }
}