import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.minipoibottomsheets.poi_overview
import com.example.minipoibottomsheets.poi_photos
import com.example.minipoibottomsheets.poi_wiki

class PageAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return poi_overview()
            }
            1 -> {
                return poi_wiki()
            }
            2 -> {
                return poi_photos()
            }
            else -> {
                return poi_overview()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Tab 1"
            }
            1 -> {
                return "Tab 2"
            }
            2 -> {
                return "Tab 3"
            }
        }
        return super.getPageTitle(position)
    }

}