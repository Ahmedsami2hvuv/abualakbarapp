import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val shopsBtn = findViewById<Button>(R.id.shopsBtn)
        val couriersBtn = findViewById<Button>(R.id.couriersBtn)
        val preparersBtn = findViewById<Button>(R.id.preparersBtn)
        val ordersBtn = findViewById<Button>(R.id.ordersBtn)

        shopsBtn.setOnClickListener {
    val intent = Intent(this, ShopsActivity::class.java)
    startActivity(intent)
}
            // هنا نضيف intent لما نجهز الصفحة
        }

couriersBtn.setOnClickListener {
    val intent = Intent(this, CouriersActivity::class.java)
    startActivity(intent)
}

        preparersBtn.setOnClickListener {
    val intent = Intent(this, PreparersActivity::class.java)
    startActivity(intent)
}

        ordersBtn.setOnClickListener {
    val intent = Intent(this, OrdersActivity::class.java)
    startActivity(intent)
}
    }
}