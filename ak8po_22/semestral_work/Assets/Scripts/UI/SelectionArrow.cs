using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class SelectionArrow : MonoBehaviour
{
    private RectTransform rect;
    [SerializeField] private RectTransform[] options;

    private int currentPosition;

    [SerializeField] private AudioClip changeSound;
    [SerializeField] private AudioClip interactSound;

    private void Awake()
    {
        rect = GetComponent<RectTransform>();
    }


    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.W) || Input.GetKeyDown(KeyCode.UpArrow))
        {
            ChangePosition(-1);
        }

        if (Input.GetKeyDown(KeyCode.S) || Input.GetKeyDown(KeyCode.DownArrow))
        {
            ChangePosition(+1);
        }

        if (Input.GetKeyDown(KeyCode.KeypadEnter))
        {
            Interact();
        }
    }

    private void ChangePosition(int change)
    {
        currentPosition += change;

        if (change != 0)
        {
            SoundManager.instance.PlaySound(changeSound);
        }

        if (currentPosition < 0)
            currentPosition = options.Length - 1;
        else if (currentPosition > options.Length - 1)
            currentPosition = 0;
        rect.position = new Vector3(rect.position.x, options[currentPosition].position.y, 0);
    }

    private void Interact()
    {
        SoundManager.instance.PlaySound(interactSound);
        
        options[currentPosition].GetComponent<Button>().onClick.Invoke();
    }
}