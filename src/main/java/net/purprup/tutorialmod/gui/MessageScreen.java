package net.purprup.tutorialmod.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

public class MessageScreen extends Screen
{
    private static final int ELEMENT_HEIGHT = 20;
    private static final int ELEMENT_SPACING = 10;
    private TextFieldWidget textField;

    public MessageScreen(Text title)
    {
        super(title);
    }

    @Override
    protected void init()
    {
        initCloseButton();
        initToastBar();
    }

    private void initCloseButton()
    {
        Text closeButtonText = Text.of("Close");
        int closeButtonWidth = 100;
        int closeButtonX = width - closeButtonWidth - ELEMENT_SPACING;
        int closeButtonY = height - ELEMENT_HEIGHT - ELEMENT_SPACING;
        ButtonWidget closeButton = ButtonWidget.builder(
                closeButtonText, button -> client.setScreen(null)
        ).dimensions(closeButtonX, closeButtonY, closeButtonWidth, ELEMENT_HEIGHT).build();

        // Register button widget
        this.addDrawableChild(closeButton);
    }

    private void initToastBar()
    {
        int toastBarY = ELEMENT_SPACING;
        int toastBarX = ELEMENT_SPACING;

        Text toastBarText = Text.of("Toast");
        Tooltip toastBarTooltip = Tooltip.of(Text.of("Trigger toast with specified text."));
        int toastBarWidth = textRenderer.getWidth(toastBarText) + ELEMENT_SPACING;

        Text textFieldMessage = Text.of("Toast Message");
        int textFieldX = ELEMENT_SPACING + toastBarWidth + ELEMENT_SPACING;
        int textFieldWidth = width - textFieldX - ELEMENT_SPACING;
        textField = new TextFieldWidget(textRenderer, textFieldX, toastBarY, textFieldWidth,ELEMENT_HEIGHT, textFieldMessage);

        ButtonWidget toastButton = ButtonWidget.builder(
                toastBarText, button -> {
                    Text toastTitle = Text.of("Toast Title");
                    Text toastText = (textField.getText().isEmpty()) ? textFieldMessage : Text.of(textField.getText());

                    client.getToastManager().add(SystemToast.create(
                            client, SystemToast.Type.NARRATOR_TOGGLE, toastTitle, toastText
                    ));
                }
        ).dimensions(toastBarX, toastBarY, toastBarWidth, ELEMENT_HEIGHT).tooltip(toastBarTooltip).build();

        addDrawableChild(toastButton);
        addDrawableChild(textField);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);

        context.drawText(this.textRenderer, "Special Button", 40, 40 - this.textRenderer.fontHeight - 10, 0xFFFFFFFF, true);
    }
}
