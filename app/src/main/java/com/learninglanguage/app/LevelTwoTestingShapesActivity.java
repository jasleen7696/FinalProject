package com.learninglanguage.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LevelTwoTestingShapesActivity extends AppCompatActivity {

    private ImageView voice, star, square, pentagon, circle, hexagon;
    private int[] voice_clips = {
            R.raw.star,
            R.raw.square,
            R.raw.pentagon,
            R.raw.circle,
            R.raw.hexagon
    };
    private String name;
    private int count = 0;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two_testing_shapes);
        initComponents();
        mAuth = FirebaseAuth.getInstance();
        loadWord();

        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voice();
            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Star")) {
                    //pass
                    new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Shapes test successfully finished!\nLevel 02 Passed!")
                            .setPositiveText("Finish")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    FirebaseDatabase.getInstance().getReference("Level").child("level02").child(mAuth.getCurrentUser().getUid()).child("status").setValue(0).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            startActivity(new Intent(LevelTwoTestingShapesActivity.this, LevelThreeLearningAnimalsActivity.class));
                                        }
                                    });
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
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
                        new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingShapesActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Square")) {
                    //pass
                    new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Shapes test successfully finished!\nLevel 02 Passed!")
                            .setPositiveText("Finish")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    FirebaseDatabase.getInstance().getReference("Level").child("level02").child(mAuth.getCurrentUser().getUid()).child("status").setValue(0).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            startActivity(new Intent(LevelTwoTestingShapesActivity.this, LevelThreeLearningAnimalsActivity.class));
                                        }
                                    });
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
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
                        new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingShapesActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        pentagon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Pentagon")) {
                    //pass
                    new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Shapes test successfully finished!\nLevel 02 Passed!")
                            .setPositiveText("Finish")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    FirebaseDatabase.getInstance().getReference("Level").child("level02").child(mAuth.getCurrentUser().getUid()).child("status").setValue(0).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            startActivity(new Intent(LevelTwoTestingShapesActivity.this, LevelThreeLearningAnimalsActivity.class));
                                        }
                                    });
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
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
                        new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingShapesActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Circle")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Shapes test successfully finished!\nLevel 01 Passed!")
                            .setPositiveText("Finish")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    FirebaseDatabase.getInstance().getReference("Level").child("level02").child(mAuth.getCurrentUser().getUid()).child("status").setValue(0).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            startActivity(new Intent(LevelTwoTestingShapesActivity.this, LevelThreeLearningAnimalsActivity.class));
                                        }
                                    });
                                }
                            }).show();


                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
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
                        new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingShapesActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        hexagon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Hexagon")) {
                    //pass
                    new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Shapes test successfully finished!\nLevel 02 Passed!")
                            .setPositiveText("Finish")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    FirebaseDatabase.getInstance().getReference("Level").child("level02").child(mAuth.getCurrentUser().getUid()).child("status").setValue(0).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            startActivity(new Intent(LevelTwoTestingShapesActivity.this, LevelThreeLearningAnimalsActivity.class));
                                        }
                                    });
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
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
                        new MaterialStyledDialog.Builder(LevelTwoTestingShapesActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingShapesActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });
    }

    private void voice() {
        if (name.equals("Star")) {
            MediaPlayer.create(LevelTwoTestingShapesActivity.this, voice_clips[0]).start();
        } else if (name.equals("Square")) {
            MediaPlayer.create(LevelTwoTestingShapesActivity.this, voice_clips[1]).start();
        } else if (name.equals("Pentagon")) {
            MediaPlayer.create(LevelTwoTestingShapesActivity.this, voice_clips[2]).start();
        } else if (name.equals("Circle")) {
            MediaPlayer.create(LevelTwoTestingShapesActivity.this, voice_clips[3]).start();
        } else {
            MediaPlayer.create(LevelTwoTestingShapesActivity.this, voice_clips[4]).start();
        }
    }

    private void loadNextWord() {
        FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("second").addValueEventListener(new ValueEventListener() {
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
        FirebaseDatabase.getInstance().getReference("Test").child("level02").child("shapes").child("first").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    name = (String) dataSnapshot.getValue();
                    voice();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LevelTwoTestingShapesActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initComponents() {
        voice = findViewById(R.id.sound);
        star = findViewById(R.id.star);
        square = findViewById(R.id.square);
        pentagon = findViewById(R.id.pentagon);
        circle = findViewById(R.id.circle);
        hexagon = findViewById(R.id.hexagon);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,HomeActivity.class));
    }

}