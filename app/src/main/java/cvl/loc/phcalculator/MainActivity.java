package cvl.loc.phcalculator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText mKEditText;
    private TextInputEditText mKExpEditText;
    private TextInputEditText mCEditText;
    private TextInputEditText mC2EditText;
    private TextInputEditText mAnsEditText;
    private TextInputLayout mCLayout;
    private TextInputLayout mC2Layout;
    private TextInputLayout mKLayout;
    private LinearLayout mKLinearLayout;
    private TextView mSolType;
    private Switch mSwitch;
    private TextView mSwitchLabel;
    private MaterialButton mButtonCalc;
    private MaterialButton mButtonCopy;
    private ImageView mLookupImageView;

    final private int STRONG_ACID = 0;
    final private int STRONG_BASE = 1;
    final private int WEAK_ACID = 2;
    final private int WEAK_BASE = 3;
    final private int BUFFER_SOL = 4;
    final private int LOOKUP = 5;
    final private int CONVERTER = 6;
    final private int CONVERTER1 = 7;

    private int solType = STRONG_ACID;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            resetText();
            switch (item.getItemId()) {
                case R.id.strong_sol:
                    solType = STRONG_ACID;
                    new Thread(){
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showStrongAcidView();
                                }
                            });
                        }
                    }.start();

                    return true;
                case R.id.weak_sol:
                    solType = WEAK_ACID;
                    new Thread(){
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showWeakAcidView();
                                }
                            });
                        }
                    }.start();
                    return true;
                case R.id.buffer_sol:
                    solType = BUFFER_SOL;
                    new Thread(){
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showBufferSolView();
                                }
                            });
                        }
                    }.start();
                    return true;
                case R.id.lookup:
                    solType = LOOKUP;
                    new Thread(){
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showLookupView();
                                }
                            });
                        }
                    }.start();
                    return true;
                case R.id.converter:
                    solType = CONVERTER;
                    new Thread(){
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showConverterView();
                                }
                            });
                        }
                    }.start();
                    return true;
            }
            return false;
        }
    };

    private void showBufferSolView() {
        mCLayout.setVisibility(View.VISIBLE);
        mC2Layout.setVisibility(View.VISIBLE);
        mKLinearLayout.setVisibility(View.VISIBLE);
        mButtonCalc.setVisibility(View.VISIBLE);
        mLookupImageView.setVisibility(View.GONE);
        mButtonCopy.setVisibility(View.VISIBLE);
        mCLayout.setHint("Nồng độ acid");
        mSolType.setText("Dung dịch đệm");
        mSwitchLabel.setText("Loại dung dịch");
        mKLayout.setHint("Ka");
        mKExpEditText.setText("0");
        mSwitchLabel.setVisibility(View.GONE);
        mSwitch.setVisibility(View.GONE);
        mSwitch.setChecked(false);
        mAnsEditText.setVisibility(View.VISIBLE);
    }

    private void showWeakBaseView() {
        mCLayout.setVisibility(View.VISIBLE);
        mC2Layout.setVisibility(View.GONE);
        mKLinearLayout.setVisibility(View.VISIBLE);
        mButtonCalc.setVisibility(View.VISIBLE);
        mLookupImageView.setVisibility(View.GONE);
        mButtonCopy.setVisibility(View.VISIBLE);
        mKExpEditText.setText("0");
        mCLayout.setHint("Nồng độ base");
        mSolType.setText("Dung dịch base yếu");
        mSwitchLabel.setText("Loại dung dịch");
        mKLayout.setHint("Ka");
        mSwitchLabel.setVisibility(View.VISIBLE);
        mSwitch.setVisibility(View.VISIBLE);
        mSwitch.setChecked(false);
        mAnsEditText.setVisibility(View.VISIBLE);
    }

    private void showWeakAcidView() {
        mCLayout.setVisibility(View.VISIBLE);
        mC2Layout.setVisibility(View.GONE);
        mKLinearLayout.setVisibility(View.VISIBLE);
        mButtonCalc.setVisibility(View.VISIBLE);
        mLookupImageView.setVisibility(View.GONE);
        mButtonCopy.setVisibility(View.VISIBLE);
        mKExpEditText.setText("0");
        mCLayout.setHint("Nồng độ acid");
        mSolType.setText("Dung dịch acid yếu");
        mSwitchLabel.setText("Loại dung dịch");
        mSwitchLabel.setVisibility(View.VISIBLE);
        mKLayout.setHint("Ka");
        mSwitch.setVisibility(View.VISIBLE);
        mSwitch.setChecked(false);
        mAnsEditText.setVisibility(View.VISIBLE);
    }

    private void showStrongBaseView() {
        mCLayout.setVisibility(View.VISIBLE);
        mC2Layout.setVisibility(View.GONE);
        mKLinearLayout.setVisibility(View.GONE);
        mButtonCalc.setVisibility(View.VISIBLE);
        mLookupImageView.setVisibility(View.GONE);
        mButtonCopy.setVisibility(View.VISIBLE);
        mKExpEditText.setText("0");
        mCLayout.setHint("Nồng độ base");
        mSolType.setText("Dung dịch base mạnh");
        mSwitchLabel.setText("Loại dung dịch");
        mSwitchLabel.setVisibility(View.VISIBLE);
        mSwitch.setVisibility(View.VISIBLE);
        mSwitch.setChecked(false);
        mAnsEditText.setVisibility(View.VISIBLE);
    }

    private void showStrongAcidView() {
        mCLayout.setVisibility(View.VISIBLE);
        mC2Layout.setVisibility(View.GONE);
        mKLinearLayout.setVisibility(View.GONE);
        mButtonCalc.setVisibility(View.VISIBLE);
        mLookupImageView.setVisibility(View.GONE);
        mButtonCopy.setVisibility(View.VISIBLE);
        mKExpEditText.setText("0");
        mCLayout.setHint("Nồng độ acid");
        mSolType.setText("Dung dịch acid mạnh");
        mSwitchLabel.setText("Loại dung dịch");
        mSwitchLabel.setVisibility(View.VISIBLE);
        mSwitch.setVisibility(View.VISIBLE);
        mSwitch.setChecked(false);
        mAnsEditText.setVisibility(View.VISIBLE);
    }

    private void showLookupView(){
        mSwitchLabel.setVisibility(View.GONE);
        mSwitch.setVisibility(View.GONE);
        mKLinearLayout.setVisibility(View.GONE);
        mCLayout.setVisibility(View.GONE);
        mC2Layout.setVisibility(View.GONE);
        mButtonCalc.setVisibility(View.GONE);
        mLookupImageView.setVisibility(View.VISIBLE);
        mSolType.setText("Tra cứu");
        mAnsEditText.setVisibility(View.GONE);
        mButtonCopy.setVisibility(View.GONE);
    }

    private void showConverterView(){
        mCLayout.setVisibility(View.VISIBLE);
        mC2Layout.setVisibility(View.GONE);
        mKLinearLayout.setVisibility(View.GONE);
        mButtonCalc.setVisibility(View.VISIBLE);
        mLookupImageView.setVisibility(View.GONE);
        mButtonCopy.setVisibility(View.VISIBLE);
        mCLayout.setHint("pKa");
        mSolType.setText("Chuyển đổi giữa pKa và Ka");
        mSwitchLabel.setText("pKa -> Ka");
        mSwitchLabel.setVisibility(View.VISIBLE);
        mSwitch.setVisibility(View.VISIBLE);
        mSwitch.setChecked(false);
        mAnsEditText.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mKEditText = findViewById(R.id.k);
        mKLayout = findViewById(R.id.text_input_text_layout_k);
        mKLinearLayout = findViewById(R.id.linear_layout_k);
        mKExpEditText = findViewById(R.id.k_exp);
        mCLayout = findViewById(R.id.concentration_layout);
        mC2Layout = findViewById(R.id.concentration2_layout);
        mCEditText = findViewById(R.id.concentration);
        mC2EditText = findViewById(R.id.concentration2);
        mAnsEditText = findViewById(R.id.ans);
        mSolType = findViewById(R.id.sol_type);
        mSwitch = findViewById(R.id.type_switch);
        mSwitchLabel = findViewById(R.id.switch_label);
        mButtonCalc = findViewById(R.id.button_calc);
        mButtonCopy = findViewById(R.id.copy_button);
        mLookupImageView = findViewById(R.id.lookup_image_view);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private double CalcPHFromHConcentration(double concentration)
    {
        return -Math.log10(concentration);
    }

    private double CalcPHFromOHConcentration(double concentration)
    {
        return 14 + Math.log10(concentration);
    }

    private double strongAcidCalc(double c){
        return CalcPHFromHConcentration(c);
    }

    private double strongBaseCalc(double c){
        return CalcPHFromOHConcentration(c);
    }

    private double weakAcidCalc(double c, double ka){
        double delta = ka * ka + 4 * ka * c;
        double h = (-ka + Math.sqrt(delta)) / 2.0;
        return CalcPHFromHConcentration(h);
    }

    private double weakBaseCalc(double c, double kb){
        double delta = kb * kb + 4 * kb * c;
        double oh = (-kb + Math.sqrt(delta)) / 2.0;
        return CalcPHFromOHConcentration(oh);
    }

    private double bufferSolCalc(double c1, double c2, double ka){
        return -Math.log10(ka) + Math.log10(c2 / c1);
    }

    public void calcAnswer(View view) {
        switch(solType){
            case STRONG_ACID:
                try{
                    double c = Double.valueOf(mCEditText.getText().toString());
                    mAnsEditText.setText(String.valueOf(strongAcidCalc(c)));
                } catch (Exception e){
                    showErrorDialog();
                }
                break;
            case WEAK_ACID:
                try{
                    double c = Double.valueOf(mCEditText.getText().toString());
                    double k = Double.valueOf(mKEditText.getText().toString()) * Math.pow(10, Double.valueOf(mKExpEditText.getText().toString()));
                    mAnsEditText.setText(String.valueOf(weakAcidCalc(c, k)));
                } catch (Exception e){
                    showErrorDialog();
                }
                break;
            case STRONG_BASE:
                try{
                    double c = Double.valueOf(mCEditText.getText().toString());
                    mAnsEditText.setText(String.valueOf(strongBaseCalc(c)));
                } catch (Exception e){
                    showErrorDialog();
                }
                break;
            case WEAK_BASE:
                try{
                    double c = Double.valueOf(mCEditText.getText().toString());
                    double k = Double.valueOf(mKEditText.getText().toString()) * Math.pow(10, Double.valueOf(mKExpEditText.getText().toString()));
                    mAnsEditText.setText(String.valueOf(weakBaseCalc(c, k)));
                } catch (Exception e){
                    showErrorDialog();
                }
                break;
            case BUFFER_SOL:
                try{
                    double c = Double.valueOf(mCEditText.getText().toString());
                    double c2 = Double.valueOf(mC2EditText.getText().toString());
                    double k = Double.valueOf(mKEditText.getText().toString()) * Math.pow(10, Double.valueOf(mKExpEditText.getText().toString()));
                    mAnsEditText.setText(String.valueOf(bufferSolCalc(c, c2, k)));
                } catch (Exception e){
                    showErrorDialog();
                }
                break;
            case CONVERTER:
                try{
                    double pka = Double.valueOf(mCEditText.getText().toString());
                    mAnsEditText.setText(String.valueOf(Math.pow(10, -pka)));
                } catch(Exception e){
                    showErrorDialog();
                }
                break;
            case CONVERTER1:
                try{
                    double ka = Double.valueOf(mCEditText.getText().toString());
                    mAnsEditText.setText(String.valueOf(-Math.log10(ka)));
                } catch(Exception e){
                    showErrorDialog();
                }
                break;
            default:
                break;
        }
    }

    private void showErrorDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setMessage("Bạn phải nhập đầy đủ các số hợp lệ!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialogBuilder.create().show();
    }

    private void resetText(){
        mAnsEditText.setText("");
        mCEditText.setText("");
        mC2EditText.setText("");
        mKEditText.setText("");
    }

    public void typeSwitchOnClick(View view) {
        if(solType == STRONG_ACID || solType == WEAK_ACID)
            solType += 1;
        else if(solType == STRONG_BASE || solType == WEAK_BASE)
            solType -= 1;
        else if(solType == CONVERTER)
            solType = CONVERTER1;
        else if(solType == CONVERTER1)
            solType = CONVERTER;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch(solType){
                    case STRONG_ACID:
                        mCLayout.setHint("Nồng độ acid");
                        mSolType.setText("Dung dịch acid mạnh");
                        mKLayout.setHint("Ka");
                        break;
                    case WEAK_ACID:
                        mCLayout.setHint("Nồng độ acid");
                        mSolType.setText("Dung dịch acid yếu");
                        mKLayout.setHint("Ka");
                        break;
                    case STRONG_BASE:
                        mCLayout.setHint("Nồng độ base");
                        mSolType.setText("Dung dịch base mạnh");
                        mKLayout.setHint("Kb");
                        break;
                    case WEAK_BASE:
                        mCLayout.setHint("Nồng độ base");
                        mSolType.setText("Dung dịch base yếu");
                        mKLayout.setHint("Kb");
                        break;
                    case CONVERTER:
                        mSwitchLabel.setText("pKa -> Ka");
                        mCLayout.setHint("pKa");
                        break;
                    case CONVERTER1:
                        mCLayout.setHint("Ka");
                        mSwitchLabel.setText("Ka -> pKa");
                        break;
                }
            }
        });
    }

    public void copyAns(View view) {
        if(mAnsEditText.getText() != null){
            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(ClipData.newPlainText("copy data", mAnsEditText.getText().toString()));
        }
    }
}
