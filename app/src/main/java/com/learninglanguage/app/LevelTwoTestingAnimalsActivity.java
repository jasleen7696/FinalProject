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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LevelTwoTestingAnimalsActivity extends AppCompatActivity {

    private ImageView voice, lion, bear, horse, parrot, owl;
    private int[] voice_clips = {
            R.raw.lion,
            R.raw.bear,
            R.raw.horse,
            R.raw.parrot,
            R.raw.owl
    };
    private String name;
    private int count = 0;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two_testing_animals);
        initComponents();
        mAuth = FirebaseAuth.getInstance();
        loadWord();

        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voice();
            }
        });

        lion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Lion")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Animal test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelTwoTestingAnimalsActivity.this, LevelTwoTestingColorsActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
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
                        new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingAnimalsActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        bear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Bear")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Animal test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelTwoTestingAnimalsActivity.this, LevelTwoTestingColorsActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
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
                        new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingAnimalsActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        horse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Horse")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Animal test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelTwoTestingAnimalsActivity.this, LevelTwoTestingColorsActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
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
                        new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingAnimalsActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        parrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Parrot")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Animal test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelTwoTestingAnimalsActivity.this, LevelTwoTestingColorsActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
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
                        new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingAnimalsActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });

        owl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("Owl")) {
                    //pass

                    new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
                            .setTitle("Correct!")
                            .setDescription("Animal test successfully finished!")
                            .setPositiveText("Next")
                            .setCancelable(false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    startActivity(new Intent(LevelTwoTestingAnimalsActivity.this, LevelTwoTestingColorsActivity.class));
                                }
                            }).show();

                } else {
                    if (count == 0) {
                        count = 1;
                        new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
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
                        new MaterialStyledDialog.Builder(LevelTwoTestingAnimalsActivity.this)
                                .setTitle("Ops!")
                                .setDescription("You're failed! Try again!")
                                .setPositiveText("Start Over")
                                .setCancelable(false)
                                .onPositive(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        startActivity(new Intent(LevelTwoTestingAnimalsActivity.this, LevelTwoLearningAnimalsActivity.class));
                                    }
                                }).show();

                    }
                }
            }
        });
    }

    private void voice() {
        if (name.equals("Lion")) {
            MediaPlayer.create(LevelTwoTestingAnimalsActivity.this, voice_clips[0]).start();
        } else if (name.equals("Bear")) {
            MediaPlayer.create(LevelTwoTestingAnimalsActivity.this, voice_clips[1]).start();
        } else if (name.equals("Horse")) {
            MediaPlayer.create(LevelTwoTestingAnimalsActivity.this, voice_clips[2]).start();
        } else if (name.equals("Parrot")) {
            MediaPlayer.create(LevelTwoTestingAnimalsActivity.this, voice_clips[3]).start();
        } else {
            MediaPlayer.create(LevelTwoTestingAnimalsActivity.this, voice_clips[4]).start();
        }
    }

    private void loadNextWord() {
        FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("second").addValueEventListener(new ValueEventListener() {
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
        FirebaseDatabase.getInstance().getReference("Test").child("level02").child("animal").child("first").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    name = (String) dataSnapshot.getValue();
                    voice();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LevelTwoTestingAnimalsActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initComponents() {
        voice = findViewById(R.id.sound);
        lion = findViewById(R.id.lion);
        bear = findViewById(R.id.bear);
        horse = findViewById(R.id.horse);
        parrot = findViewById(R.id.parrot);
        owl = findViewById(R.id.owl);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,HomeActivity.class));
    }

}