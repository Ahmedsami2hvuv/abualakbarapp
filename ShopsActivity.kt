import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ShopsActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>

    private val shops = mutableListOf<Pair<String, String>>() // اسم، رابط

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)

        listView = findViewById(R.id.shopsList)
        val addBtn = findViewById<Button>(R.id.addShopBtn)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        listView.adapter = adapter

        addBtn.setOnClickListener {
            showAddDialog()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val url = shops[position].second
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            Toast.makeText(this, "تعديل المحل: ${shops[position].first}", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun showAddDialog() {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
        }

        val nameInput = EditText(this).apply { hint = "اسم المحل" }
        val urlInput = EditText(this).apply { hint = "رابط المحل" }

        layout.addView(nameInput)
        layout.addView(urlInput)

        AlertDialog.Builder(this)
            .setTitle("إضافة