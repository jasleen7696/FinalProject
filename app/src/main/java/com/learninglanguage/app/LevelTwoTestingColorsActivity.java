package com.learninglanguage.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LevelTwoTestingColorsActivity extends AppCompatActivity {

    private ImageView black,purple,green,red,white;
    private ImageView voice;
    private int[] voice_clips = {
            R.raw.black,
            R.raw.purple,
            R.raw.green,
            R.raw.red,
            R.raw.white
    };
    private String name;
    private int count = 0;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two_testing_colors);
        initComponents();
        mAuth = FirebaseAuth.getInstance();
        loadWord();

        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voice();
            }
        });

        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Black")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Color test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelTwoTestingColorsActivity.this, LevelTwoTestingShapesActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level02").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingColorsActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Purple")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Color test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelTwoTestingColorsActivity.this, LevelTwoTestingShapesActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level02").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingColorsActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Green")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Color test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelTwoTestingColorsActivity.this, LevelTwoTestingShapesActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level02").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingColorsActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Red")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Color test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelTwoTestingColorsActivity.this, LevelTwoTestingShapesActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level02").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingColorsActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("White")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Color test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelTwoTestingColorsActivity.this, LevelTwoTestingShapesActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("First attempt failed! Try again!")
                                .setPositiveText("Try Again")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        loadNextWord();
                                    }
                                }).show();
                    } else {
                        //doitagain
                        FirebaseDatabase.getInstance().getReference("Level").child("level02").child(mAuth.getCurrentUser().getUid()).child("status").setValue(1);
                        new MaterialStyledDialog.Builder(LevelTwoTestingColorsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingColorsActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });
    }

    private void voice() {
        if (name.equals("Black")) {
            MediaPlayer.create(LevelTwoTestingColorsActivity.this, voice_clips[0]).start();
        } else if (name.equals("Purple")) {
            MediaPlayer.create(LevelTwoTestingColorsActivity.this, voice_clips[1]).start();
        } else if (name.equals("Green")) {
            MediaPlayer.create(LevelTwoTestingColorsActivity.this, voice_clips[2]).start();
        } else if (name.equals("Red")) {
            MediaPlayer.create(LevelTwoTestingColorsActivity.this, voice_clips[3]).start();
        } else {
            MediaPlayer.create(LevelTwoTestingColorsActivity.this, voice_clips[4]).start();
        }
    }

    private void loadNextWord() {
        FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("second").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    name = (String) dataSnapshot.getValue();
                    voice();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void loadWord() {
        FirebaseDatabase.getInstance().getReference("Test").child("level02").child("colors").child("first").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    name = (String) dataSnapshot.getValue();
                    voice();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LevelTwoTestingColorsActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initComponents() {
        voice = findViewById(R.id.sound);
        black = findViewById(R.id.black);
        purple = findViewById(R.id.purple);
        green = findViewById(R.id.green);
        red = findViewById(R.id.red);
        white = findViewById(R.id.white);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,HomeActivity.class));
    }

}